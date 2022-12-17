package com.example.democomb2;

import javax.persistence.*;

@Entity
@Table(name = "words")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCodeParent() {
        return codeParent;
    }

    public void setCodeParent(Integer codeParent) {
        this.codeParent = codeParent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeSub() {
        return typeSub;
    }

    public void setTypeSub(String typeSub) {
        this.typeSub = typeSub;
    }

    public String getTypeSsub() {
        return typeSsub;
    }

    public void setTypeSsub(String typeSsub) {
        this.typeSsub = typeSsub;
    }

    public Boolean getPlural() {
        return plural;
    }

    public void setPlural(Boolean plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWcase() {
        return wcase;
    }

    public void setWcase(String wcase) {
        this.wcase = wcase;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public Boolean getSoul() {
        return soul;
    }

    public void setSoul(Boolean soul) {
        this.soul = soul;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public Boolean getPerfect() {
        return perfect;
    }

    public void setPerfect(Boolean perfect) {
        this.perfect = perfect;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getInf() {
        return inf;
    }

    public void setInf(Boolean inf) {
        this.inf = inf;
    }

    public Boolean getVozv() {
        return vozv;
    }

    public void setVozv(Boolean vozv) {
        this.vozv = vozv;
    }

    public String getNakl() {
        return nakl;
    }

    public void setNakl(String nakl) {
        this.nakl = nakl;
    }

    public Boolean getShortField() {
        return shortField;
    }

    public void setShortField(Boolean shortField) {
        this.shortField = shortField;
    }

}