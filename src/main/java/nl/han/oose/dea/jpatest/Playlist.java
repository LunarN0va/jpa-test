package nl.han.oose.dea.jpatest;

import javax.persistence.*;

@Entity
@Table(name = "PLAYLISTS")
public class Playlist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String owner;

    public Playlist() {
    }

    public Playlist(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
