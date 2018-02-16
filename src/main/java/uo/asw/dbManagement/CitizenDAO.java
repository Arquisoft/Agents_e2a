package uo.asw.dbManagement;

import uo.asw.dbManagement.model.Citizen;

/**
 * @since 0.0.1
 */
public interface CitizenDAO {
    Citizen getAgent(String login, String password, String kind);
    Citizen updateInfo(Citizen toUpdate);
}
