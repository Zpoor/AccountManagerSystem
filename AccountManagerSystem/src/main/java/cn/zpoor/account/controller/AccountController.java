package cn.zpoor.account.controller;

import cn.zpoor.account.domain.Account;
import cn.zpoor.account.service.AccountService;

import java.util.List;

/**
 * 控制器模拟，前端接收返回数据
 */
public class AccountController {
    private AccountService accountService = new AccountService();

    /**
     * 实现账务信息的编辑
     */
    public void editAccount(Account account) {
        accountService.editAccount(account);
    }

    /**
     * 实现账务信息的添加
     */
    public void addAccount(Account account) {
        accountService.addAccount(account);
    }

    /**
     * 查询所有的账务信息
     */
    public List<Account> findAll() {
        return accountService.findAll();
    }

    /**
     * 查询规定范围内的账务信息
     */
    public List<Account> findAccountByTime(String startTime, String endTime) {
        return accountService.findAccountByTime(startTime,endTime);
    }

    /**
     * 按照id删除账务
     */
    public void deleteAccount(int id) {
        accountService.deleteAccount(id);
    }
}
