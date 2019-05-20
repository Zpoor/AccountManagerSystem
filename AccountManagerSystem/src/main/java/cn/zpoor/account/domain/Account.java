package cn.zpoor.account.domain;

/**
 * 账务的实体类
 */
public class Account {
    private Integer id;
    private String name;
    private Double money;
    private String account;
    private String createtime;
    private String description;

    public Account() {
    }

    public Account(Integer id, String name, Double money, String account, String createtime, String description) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.account = account;
        this.createtime = createtime;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", account='" + account + '\'' +
                ", createtime='" + createtime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
