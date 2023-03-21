package com.modeal.springbatch.jpo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ipausers {

    @Id
    @GeneratedValue
    private Long USER_IDX;
    private String EMAIL;
    private String SALT;
    private String USERID;
    private String USERPW;
}
