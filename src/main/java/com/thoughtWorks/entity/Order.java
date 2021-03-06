package com.thoughtWorks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 马欢欢
 * @date 18-1-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer oId;
    private String oCode;
    private String oPromotion;
    private String oOrderTime;
    private String oSettlementTime;
    private Integer oDuration;
    private String oNotes;
    private Integer oFinish;
    private Double oModelPrice;
    private String oModelIntroduce;
    private String oModelVersion;
    private String oModelCode;
    private Integer customId;
    private Integer modelId;
    private String oThumbnail;
    private String oName;
}
