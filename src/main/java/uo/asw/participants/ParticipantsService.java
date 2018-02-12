package uo.asw.participants;


import uo.asw.dbManagement.model.Citizen;
import uo.asw.participants.util.CitizenMin;

/**
 * Servicio de participantes
 * @since 0.0.1
 */
public interface ParticipantsService {
    CitizenMin getParticipantsInfo(String login, String password);
    Citizen changeInfo(Citizen updatedData);
}
