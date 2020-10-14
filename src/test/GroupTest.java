package test;

import mainPackage.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    private Group group;
    private Person chief;

    @BeforeEach
    void setUp() {
        this.chief = new Person(1, "Manel");
        this.group = new Group(this.chief);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteMember() {
        Person personToDelete = new Person(2, "Outro Manel");
        this.group.addMember(personToDelete);
        this.group.deleteMember(personToDelete);
        assertThrows(GroupException.class, () -> this.group.deleteMember(this.chief));
        assertThrows(GroupException.class, () -> this.group.deleteMember(null));
    }

    @Test
    void changeChief() {
        Person personToChief = new Person(2, "Outro Manel");
        assertThrows(GroupException.class, () -> this.group.changeChief(personToChief));
        this.group.addMember(personToChief);
        this.group.changeChief(personToChief);
    }

    @Test
    void addMember() {
        Person personToAdd = new Person(2, "Outro Manel");
        this.group.addMember(personToAdd);
        assertThrows(GroupException.class, () -> this.group.addMember(personToAdd));
    }

    @Test
    void testToString() {
        assertNotEquals(this.group.toString(), "");
    }
}