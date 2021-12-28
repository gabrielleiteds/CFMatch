package com.example.cfmatch.value_objects;

import java.util.ArrayList;
import java.util.List;

class Interest {
    public long id;
    public String name;
}

public class InterestsEnum {
    public static List<Interest> interests;

    public InterestsEnum () {
        // Singleton
        if (interests.isEmpty()) {
            setInterests();
        }

    }

    private void setInterests () {
        interests = new ArrayList<>();
    }

}
