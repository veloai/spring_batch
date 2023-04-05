package com.modeal.springbatch.jpo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "batch_kakao_vo")
public class KaKaoVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kakaoMessageType;
    private String kakaoReserveDt;
    private String kakaoKey;
    private String kakaoUserId;
    private String kakaoSendUrl;
    private String encKey;
    private String smsSender;

}
