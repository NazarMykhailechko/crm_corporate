package ua.crm.corporate.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GeneralID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public GeneralID() {
    }

   public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralID)) return false;

        GeneralID generalID = (GeneralID) o;

        return getId() == generalID.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    @Override
    public String toString() {
        return "GeneralID{" +
                "id=" + id +
                '}';
    }
}
