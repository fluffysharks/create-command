package search.command.create_command.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.micrometer.common.util.StringUtils;
import search.command.create_command.form.createCommandForm;

@Controller
public class CreateCommandController {

    @RequestMapping(value = "/createTwitterCommand", method = RequestMethod.GET)
    public String init(Model model, createCommandForm form) {
        model.addAttribute("form", form);
        return "createCommand";
    }

    @RequestMapping(value = "/createTwitterCommand", params = "generateCommand", method = RequestMethod.POST)
    public String displayCommand(Model model, createCommandForm form) {
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

        if (!StringUtils.isEmpty(form.getMinFaves())) {
            // 「いいね数（Min）」が入力されていればmin_faves検索を追加
            command.append("min_faves:" + form.getMinFaves() + " ");
        }

        if (!StringUtils.isEmpty(form.getMaxFaves())) {
            // 「いいね数（Max）」が入力されていればmax_faves検索を追加F
            command.append("max_faves:" + form.getMaxFaves() + " ");
        }

        if (!StringUtils.isEmpty(form.getDateUntil())) {
            // 「フォロイーの投稿に絞って表示」が入力されていればfilter:followsを追加
            command.append("filter:follows ");
        }
        // if (!StringUtils.isEmpty(form.getDateUntil())) {
        // // 「フォロワーの投稿に絞って表示」が入力されていればを追加
        // command.append("filter:followers ");
        // }

        model.addAttribute("command", command);

        model.addAttribute("form", form);
        return "createCommand";
    }

}
