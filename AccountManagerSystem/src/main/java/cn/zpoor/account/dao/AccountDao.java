package cn.zpoor.account.dao;

import cn.zpoor.account.domain.Account;
import cn.zpoor.account.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账务持久层
 */
public class AccountDao {
    private QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());


    /**
     * 实现账务信息的编辑
     */
    public void editAccout(Account account) {
        String sql = "update account set name=?,money=?,account=?,createtime=?,description=? where id=?";
        Object[] params = {account.getName(), account.getMoney(), account.getAccount(), account.getCreatetime(), account.getDescription(), account.getId()};
        try {
            runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改账务信息失败");
        }
    }

    public void addAcount(Account account) {
        String sql = "insert into account (name,money,account,createtime,description) values (?,?,?,?,?)";
        Object[] params = {account.getName(), account.getMoney(), account.getAccount(), account.getCreatetime(), account.getDescription()};
        try {
            runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加账务信息失败");
        }
    }

    /**
     * 实现查询所有账务信息
     *
     * @return accouts 返回所有账务信息
     */
    public List<Account> findAll() {
        String sql = "select * from account";
        try {
            List<Account> accounts = runner.query(sql, new BeanListHandler<Account>(Account.class));
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有账务信息失败");
        }
    }

    /**
     * 实现查询按照指定时间内的账务信息
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 返回查询到指定时间范围内的账务信息
     */
    public List<Account> findAccountByTime(String startTime, String endTime) {
        String sql = "select * from account where createtime between ? and ?";
        Object[] params = {startTime, endTime};
        try {
            List<Account> accounts = runner.query(sql, new BeanListHandler<Account>(Account.class), params);
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("按照时间条件查询失败");
        }
    }

    /**
     * 按照指定的账户id删除账务
     * @param id  账务的id
     */
    public void deleteAccount(int id) {
        String sql = "delete from account where id=?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除账务失败");
        }
    }

}
