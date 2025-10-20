package search.command.create_command.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import search.command.create_command.form.CreateCommandForm;

@Controller
public class CreateCommandController {

    @RequestMapping(value = "/createTwitterCommand", method = RequestMethod.GET)
    public String init(Model model, CreateCommandForm form) {
        model.addAttribute("form", form);
        return "createCommand";
    }

    @RequestMapping(value = "/createTwitterCommand", params = "generateCommand", method = RequestMethod.POST)
    public String displayCommand(Model model, @ModelAttribute("form") @Valid CreateCommandForm form,
            BindingResult bindingResult) {

        boolean compareError = false;

        if (bindingResult.hasErrors()) {
            // バリデーションチェックでエラーがあった場合
            compareError = true;
        }

        // 相関チェック 期間
        if (!StringUtils.isEmpty(form.getDateSince()) && !StringUtils.isEmpty(form.getDateUntil())) {
            if (toDate(form.getDateSince()).after(toDate(form.getDateUntil()))) {
                // 期間（From）が期間（To）以後
                model.addAttribute("compareDate", "期間（From）には期間（To）以前の日付を入力してください");
                compareError = true;

            }
        }

        // 相関チェック いいね数
        if (!StringUtils.isEmpty(form.getMinFaves()) && !StringUtils.isEmpty(form.getMaxFaves())) {
            if (Integer.parseInt(form.getMinFaves()) > Integer.parseInt(form.getMaxFaves())) {
                // いいね数（Min）がいいね数（Max）よりも大きい
                model.addAttribute("compareFaves", "いいね数（Min）にはいいね数（Max）以下の値を入力してください");
                compareError = true;
            }
        }

        if (compareError) {
            // チェックでエラーがあった場合
            return "createCommand";
        }

        StringBuilder command = new StringBuilder();

        if (!StringUtils.isEmpty(form.getUserName())) {
            // 「ユーザー名」が入力されていれば、from検索を追加
            command.append("from:" + form.getUserName() + " ");
        }

        if (!StringUtils.isEmpty(form.getDateSince())) {
            // 「期間（Since）」が入力されていればsince検索を追加
            command.append("since:" + form.getDateSince() + " ");
        }

        if (!StringUtils.isEmpty(form.getDateUntil())) {
            // 「期間（To）」が入力されていればto検索を追加
            command.append("until:" + form.getDateUntil() + " ");
        }

        if (!StringUtils.isEmpty(form.getKeyword())) {
            // 「キーワード（完全一致）」が入力されていればキーワード（完全一致）を追加
            command.append("\"" + form.getKeyword() + "\"");
        }

        if (!StringUtils.isEmpty(form.getFollowee())) {
            // 「フォロイーの投稿に絞って表示」が選択されていればfilter:followsを追加
            command.append("filter:follows ");
        }

        if (!StringUtils.isEmpty(form.getPictures())) {
            // 「画像投稿のみ表示」が選択されていればfilter:imagesを追加
            command.append("filter:images ");
        }

        if (!StringUtils.isEmpty(form.getRemoveKeyword())) {
            // 「除外するキーワード（完全一致）」が入力されていれば除外するキーワード（完全一致）を追加
            command.append("-\"" + form.getRemoveKeyword() + "\"");
        }

        if (!StringUtils.isEmpty(form.getMinFaves())) {
            // 「いいね数（Min）」が入力されていればmin_faves検索を追加
            command.append("min_faves:" + form.getMinFaves() + " ");
        }

        if (!StringUtils.isEmpty(form.getMaxFaves())) {
            // 「いいね数（Max）」が入力されていればmax_faves検索を追加F
            command.append("max_faves:" + form.getMaxFaves() + " ");
        }

        if (!StringUtils.isEmpty(form.getReply())) {
            // 「特定ユーザー宛ての返信」が入力されていれば、to検索を追加
            command.append("to:" + form.getReply() + " ");
        }

        model.addAttribute("command", command);

        return "createCommand";
    }

    /**
     * 文字列を日付に変換する
     * 
     * @param str String型の文字列
     * @return strをDate型に変換した値
     */
    private Date toDate(String str) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return date.parse(str);
        } catch (Exception e) {
            return null;
        }
    }

}
