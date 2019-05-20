package cn.zpoor.account.view;

import cn.zpoor.account.controller.AccountController;
import cn.zpoor.account.domain.Account;

import java.util.List;
import java.util.Scanner;

/**
 * 视图层：用户看到的界面
 * 数据传递给控制层
 */
public class MainView {
    private AccountController accountController = new AccountController();

    /**
     * 模拟实现前端效果，接收用户输入，根据数字的选择，选择不同的功能
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("----------------Zpoor家庭记账软件----------------");
            System.out.println("1. 添加账务　2. 编辑账务　3. 删除账务　4. 查询账务　5. 退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            //接收用户的输入
            int choose = scanner.nextInt();
            //接收判断
            switch(choose) {
                case 1:
                    //添加账务信息
                    addCount();
                    break;
                case 2:
                    //编辑账务信息
                    editAccount();
                    break;
                case 3:
                    //删除账务信息
                    deleteAccount();
                    break;
                case 4:
                    //查询账务信息
                    selectAccount();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private void selectAccount() {
        System.out.println("1.  查询所有  2.  条件查询");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();

        switch (choose) {
            case 1:
                //查询所有账务信息
                findAll();
                break;

            case 2:
                //按照时间范围内账务信息
                findAccountByTime();
                break;
        }
    }

    /**
     * 按照指定的id删除账务信息
     */
    private void deleteAccount() {
        findAll();
        System.out.println("选择的是删除功能，输入序号");
        int id = new Scanner(System.in).nextInt();
        accountController.deleteAccount(id);
        System.out.println("删除账务成功");
    }

    /**
     * 编辑账务信息
     */
    private void editAccount() {
        findAll();
        System.out.println("选择的是编辑功能，请输入数据");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入ID");
        int id = scanner.nextInt();
        System.out.println("请输入分类名称");
        String name = scanner.next();
        System.out.println("输入金额");
        double money = scanner.nextDouble();
        System.out.println("输入账户");
        String account = scanner.next();
        System.out.println("输入日期：格式 XXXX-XX-XX");
        String createtime = scanner.next();
        System.out.println("输入具体描述");
        String description = scanner.next();
        //输入的数据封装成对象
        Account accounts = new Account(id, name, money, account, createtime, description);
        accountController.editAccount(accounts);
        System.out.println("账务编辑成功");
    }

    /**
     * 添加账务信息
     */
    private void addCount() {
        System.out.println("选择的添加账务的功能，请输入以下内容");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入分类名称");
        String name = scanner.next();
        System.out.println("输入金额");
        double money = scanner.nextDouble();
        System.out.println("输入账户");
        String account = scanner.next();
        System.out.println("输入日期：格式 XXXX-XX-XX");
        String createtime = scanner.next();
        System.out.println("输入具体描述");
        String description = scanner.next();
        Account accounts = new Account(0, name, money, account, createtime, description);
        accountController.addAccount(accounts);
        System.out.println("恭喜！添加账务成功");
    }

    /**
     * 查询所有的账务信息
     */
    public void findAll() {
        List<Account> accounts = accountController.findAll();
        if (accounts.size() != 0) {
            print(accounts);
        } else {
            System.out.println("没有查询到数据");
        }
    }

    /**
     * 查询指定范围内的账务信息
     */
    public void findAccountByTime() {
        System.out.println("选择条件查询，输入日期格式为XXXX-XX-XX");
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始日期:");
        String startDate = sc.nextLine();
        System.out.println("请输入结束日期:");
        String endDate = sc.nextLine();
        List<Account> accounts = accountController.findAccountByTime(startDate, endDate);
        if (accounts.size() != 0) {
            print(accounts);
        } else {
            System.out.println("没有查询到数据");
        }
    }

    /**
     * 按照格式输出查询到的账务信息
     * @param accounts
     */
    private void print(List<Account> accounts) {
        System.out.println("ID\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        for (Account account : accounts) {
            System.out.println(account.getId() + "\t" + account.getName()+ "\t\t" + account.getAccount() + "\t\t" + account.getMoney() + "\t\t" + account.getCreatetime() + "\t" +account.getDescription());
        }
    }
}
