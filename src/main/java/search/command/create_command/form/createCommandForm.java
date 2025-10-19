package search.command.create_command.form;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCommandForm {

    /** ユーザー名 */
    @Size(max = 50, message = "ユーザー名は50文字以内で入力してください")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "ユーザー名は半角英数字＋アンダーバーで入力してください")
    private String userName;

    /** 期間（Since） */
    private String dateSince;

    /** 期間（Until） */
    private String dateUntil;
    /** キーワード */
    @Size(max = 20, message = "キーワードは20文字以内で入力してください")
    private String keyword;

    /** フォロイーの投稿を表示 */
    private String followee;

    /** 画像投稿を表示 */
    private String pictures;

    /** いいね数（Min） */
    private String minFaves;

    /** いいね数（Max） */
    private String maxFaves;

    /**
     * ユーザー名を取得
     * 
     * @return ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を設定
     * 
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 期間（Since）を取得
     * 
     * @return 期間（Since）
     */
    public String getDateSince() {
        return dateSince;
    }

    /**
     * 期間（Since）を設定
     * 
     * @param dateSince 期間（Since）
     */
    public void setDateSince(String dateSince) {
        this.dateSince = dateSince;
    }

    /**
     * 期間（Until）を取得
     * 
     * @return 期間（Until）
     */
    public String getDateUntil() {
        return dateUntil;
    }

    /**
     * 期間（Until）を設定
     * 
     * @param dateUntil 期間（Until）
     */
    public void setDateUntil(String dateUntil) {
        this.dateUntil = dateUntil;
    }

    /**
     * キーワードを取得
     * 
     * @return キーワード
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * キーワードを設定
     * 
     * @param keyword キーワード
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * followeeを取得
     * 
     * @return followee
     */
    public String getFollowee() {
        return followee;
    }

    /**
     * followeeを設定
     * 
     * @param followee
     */
    public void setFollowee(String followee) {
        this.followee = followee;
    }

    /**
     * picturesを取得
     * 
     * @return pictures
     */
    public String getPictures() {
        return pictures;
    }

    /**
     * picturesを設定
     * 
     * @param pictures
     */
    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    /**
     * いいね数（Min）を取得
     * 
     * @return minFaves
     */
    public String getMinFaves() {
        return minFaves;
    }

    /**
     * いいね数（Min）を設定
     * 
     * @param minFaves いいね数（Min）
     */
    public void setMinFaves(String minFaves) {
        this.minFaves = minFaves;
    }

    /**
     * いいね数（Max）を取得
     * 
     * @return maxFaves
     */
    public String getMaxFaves() {
        return maxFaves;
    }

    /**
     * いいね数（Max）を設定
     * 
     * @param maxFaves いいね数（Max）
     */
    public void setMaxFaves(String maxFaves) {
        this.maxFaves = maxFaves;
    }
}
