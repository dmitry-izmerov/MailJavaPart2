package ru.demi.app.accountServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountServerController implements AccountServerControllerMBean {
    private final AccountServer accountServer;
    private static final Logger logger = LogManager.getLogger(AccountServerController.class);

    public AccountServerController(AccountServer accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public int getUsers() {
        return accountServer.getUsersCount();
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit(int limit) {
        accountServer.setUsersLimit(limit);
        logger.info("Calling of AccountServerController.setUsersLimit with param: " + limit);
    }
}
