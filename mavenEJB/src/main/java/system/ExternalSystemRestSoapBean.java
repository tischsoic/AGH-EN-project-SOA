package system;

import models.*;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Remote(ExternalSystemRestSoap.class)
public class ExternalSystemRestSoapBean implements ExternalSystemRestSoap {

    @Lock(LockType.READ)
    public List<Zone> getAllZones() {
        return getAllFromTable("Zone");
    }

    @Lock(LockType.READ)
    public Zone getOneZone(Long zoneId) {
        return getOneFromTable("Zone", "zone_id", zoneId);
    }

    @Lock(LockType.READ)
    public List<ParkingMeter> getAllParkingMeters() {
        return getAllFromTable("ParkingMeter");
    }

    @Lock(LockType.READ)
    public ParkingMeter getOneParkingMeter(Long parkingMeterId) {
        return getOneFromTable("ParkingMeter", "parking_meter_id", parkingMeterId);
    }

    @Lock(LockType.READ)
    public List<ParkingSpace> getAllParkingSpaces() {
        return getAllFromTable("ParkingSpace");
    }

    @Lock(LockType.READ)
    public ParkingSpace getOneParkingSpace(Long parkingSpaceId) {
        return getOneFromTable("ParkingSpace", "parking_space_id", parkingSpaceId);
    }

    @Lock(LockType.READ)
    public List<Occupancy> getAllOccupancies() {
        return getAllFromTable("Occupancy");
    }

    @Lock(LockType.READ)
    public Occupancy getOneOccupancy(Long occupancyId) {
        return getOneFromTable("Occupancy", "occupancy_id", occupancyId);
    }

    @Lock(LockType.READ)
    public List<Ticket> getAllTickets() {
        return getAllFromTable("Ticket");
    }

    @Lock(LockType.READ)
    public Ticket getOneTicket(Long ticketId) {
        return getOneFromTable("Ticket", "ticket_id", ticketId);
    }

    private <T> List<T> getAllFromTable(String tableName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("from " + tableName);
        List<T> all = query.getResultList();

        em.close();
        emf.close();

        return all;
    }

    private <T> T getOneFromTable(String tableName, String idColName, Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("entityManager");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("from " + tableName + " where " + idColName + " = :id");
        query.setParameter("id", id);
        List<T> all = query.getResultList();

        em.close();
        emf.close();

        return all.size() == 1 ? all.get(0) : null;
    }
}
