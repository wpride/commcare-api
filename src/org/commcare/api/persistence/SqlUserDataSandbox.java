package org.commcare.api.persistence;

import org.commcare.api.models.LivePrototypeFactory;
import org.commcare.api.models.User;
import org.commcare.cases.ledger.Ledger;
import org.commcare.cases.model.Case;
import org.javarosa.core.model.instance.FormInstance;

/**
 * A placeholder for the in-memory storage elements needed for an individual
 * CommCare user.
 *
 * Uses a shared factory to appropriately manage prototype hashing, so can be
 * used as a reliable source of reads/writes for in-memory mocks of stoage
 * objects
 *
 * @author ctsims
 */
public class SqlUserDataSandbox {
    private final SqlIndexedStorageUtility<Case> caseStorage;
    private final SqlIndexedStorageUtility<Ledger> ledgerStorage;
    private final SqlIndexedStorageUtility<User> userStorage;
    private final SqlIndexedStorageUtility<FormInstance> userFixtureStorage;
    private final SqlIndexedStorageUtility<FormInstance> appFixtureStorage;

    /**
     * Create a sandbox of the necessary storage objects with the shared
     * factory.
     *
     * @param factory A prototype factory for deserializing records
     */
    public SqlUserDataSandbox(LivePrototypeFactory factory, String username) {
        caseStorage = new SqlIndexedStorageUtility<Case>(Case.class, factory, "Case", username);
        ledgerStorage = new SqlIndexedStorageUtility<Ledger>(Ledger.class, factory, "Ledger", username);
        userStorage = new SqlIndexedStorageUtility<User>(User.class, factory, "User", username);
        userFixtureStorage = new SqlIndexedStorageUtility<FormInstance>(FormInstance.class, factory, "User-Fixture", username);
        appFixtureStorage = new SqlIndexedStorageUtility<FormInstance>(FormInstance.class, factory, "App-Fixture", username);
    }

    public SqlIndexedStorageUtility<Case> getCaseStorage() {
        return caseStorage;
    }

    public SqlIndexedStorageUtility<Ledger> getLedgerStorage() {
        return ledgerStorage;
    }

    public SqlIndexedStorageUtility<User> getUserStorage() {
        return userStorage;
    }

    public SqlIndexedStorageUtility<FormInstance> getUserFixtureStorage() {
        return userFixtureStorage;
    }

    public SqlIndexedStorageUtility<FormInstance> getAppFixtureStorage() {
        return appFixtureStorage;
    }
}

