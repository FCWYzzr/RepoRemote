package pers.fcwy.lab02.Q2;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Person implements Serializable {
    interface V{
        int basketball = 1;
        int football = 2;
        int code = 4;
    }

    private final String name;
    private final boolean isMale;
    private final boolean isYN;
    private byte Like;

    public Person(String name, boolean isMale, boolean isYN,
                  boolean[] likes) {
        this.name = name;
        this.isMale = isMale;
        this.isYN = isYN;
        this.Like = 0;

        if( likes[0] )
            Like |= V.basketball;
        if( likes[1] )
            Like |= V.football;
        if( likes[2] )
            Like |= V.code;
    }

    public String getName() {
        return name;
    }
    public boolean isMale() {
        return isMale;
    }
    public boolean isYN() {
        return isYN;
    }
    public boolean isLike(int v){
        return (Like&v)!=0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @NonNull
    @Override
    public String toString() {
        ArrayList<String> like = new ArrayList<>(3);
        if (isLike(V.basketball))
            like.add("Basketball");
        if (isLike(V.football))
            like.add("Football");
        if (isLike(V.code))
            like.add("Coding");

        return "name: " + name + '\n' +
                "\tSex: " + (isMale?"Male":"Female") +'\n'+
                "\tHome: " + (isYN?"Yunnan":"Sichuan") + '\n' +
                "\tHobby: "+ String.join(",", like) + '\n';
    }
}
