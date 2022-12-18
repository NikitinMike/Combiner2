package com.example.democomb2;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "words")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IID", nullable = false)
    private Integer id;

    @Column(name = "word", nullable = false, length = 100)
    private String word;

    @Column(name = "code", nullable = false)
    private Integer code;

    @Column(name = "code_parent", nullable = false)
    private Integer codeParent;

    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "type_sub")
    private String typeSub;

    @Lob
    @Column(name = "type_ssub")
    private String typeSsub;

    @Column(name = "plural")
    private Boolean plural;

    @Lob
    @Column(name = "gender")
    private String gender;

    @Lob
    @Column(name = "wcase")
    private String wcase;

    @Lob
    @Column(name = "comp")
    private String comp;

    @Column(name = "soul")
    private Boolean soul;

    @Lob
    @Column(name = "transit")
    private String transit;

    @Column(name = "perfect")
    private Boolean perfect;

    @Lob
    @Column(name = "face")
    private String face;

    @Lob
    @Column(name = "kind")
    private String kind;

    @Lob
    @Column(name = "time")
    private String time;

    @Column(name = "inf")
    private Boolean inf;

    @Column(name = "vozv")
    private Boolean vozv;

    @Lob
    @Column(name = "nakl")
    private String nakl;

    @Column(name = "short")
    private Boolean shortField;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Word word = (Word) o;
        return id != null && Objects.equals(id, word.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}