package services.hospital;

import domain.appoinments.Appointment;
import domain.hospital.Room;
import services.Service;

import java.util.Set;

public interface RoomService extends Service<Room, Integer> {

    Set<Room> getAll();

}
