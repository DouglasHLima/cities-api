package com.doughlima.citiesapi.cities.entity;

import com.doughlima.citiesapi.states.entity.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@Getter
@NoArgsConstructor

@TypeDefs({
        @TypeDef(name = "point", typeClass = PointType.class)
})

public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf",referencedColumnName = "id")
    private State uf;

    @Column
    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon",updatable = false, insertable = false)
    private Point geoLocation;
}
