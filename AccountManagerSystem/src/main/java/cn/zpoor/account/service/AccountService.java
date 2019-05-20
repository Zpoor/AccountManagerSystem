package cn.zpoor.account.service;

import cn.zpoor.account.dao.AccountDao;
import cn.zpoor.account.domain.Account;

import java.util.List;

/**
 * 账务业务层
 */
public class AccountService {
    private AccountDao accountDao = new AccountDao();

    /**
     * 实现账务信息的编辑
     */
    public void editAccount(Account account) {
        accountDao.editAccout(account);
    }

    /**
     * 实现账务信息的添加
     */
    public void addAccount(Account account) {
        accountDao.addAcount(account);
    }

    /**
     * 查询所有的账务信息
     */
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    /**
     * 查询规定范围内的账务信息
     */
    public List<Account> findAccountByTime(String startTime, String endTime) {
        return accountDao.findAccountByTime(startTime,endTime);
    }

    /**
     * 按照id删除账务
     */
    public void deleteAccount(int id) {
        accountDao.deleteAccount(id);
    }
}
