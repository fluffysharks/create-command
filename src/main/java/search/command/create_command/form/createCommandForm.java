package search.command.create_command.form;

public class createCommandForm {
    /** ユーザー名 */
    private String userName;
    /** 期間（Since） */
    private String dateSince;
    /** 期間（Until） */
    private String dateUntil;
    /** フォロイーの投稿を表示 */
    private String followee;
    /** フォロワーの投稿を表示 */
    private String follower;
    /** いいね数（Min） */
    private String minFaves;
    /** いい数（Max） */
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
     * @param dateSince 期間（Until）
     */
    public void setDateUntil(String dateUntil) {
        this.dateUntil = dateUntil;
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
     * followerを取得
     * 
     * @return follower
     */
    public String getFollower() {
        return follower;
    }

    /**
     * followerを設定
     * 
     * @param follower
     */
    public void setFollower(String follower) {
        this.follower = follower;
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
