package com.doughlima.citiesapi.states.entity;

import com.doughlima.citiesapi.countries.entity.Country;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estado")
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@Getter
@NoArgsConstructor
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column
    private String uf;

    @Column
    private String ibge;

    @ManyToOne
    @JoinColumn(name = "pais",referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

}
