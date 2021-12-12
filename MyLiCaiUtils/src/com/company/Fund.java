package com.company;

public class Fund {
    /**
     * 基金代码
     **/
    private String code;
    /**
     * 基金名称
     **/
    private String name;
    /**
     * 基金类型
     **/
    private String type;
    /**
     * 净值时间
     **/
    private String date;
    /**
     * 基金净值
     **/
    private Double netValue;
    /**
     * 日增长率
     **/
    private Double dayRise;
    /**
     * 近1周
     **/
    private Double weekRise;
    /**
     * 近1个月
     **/
    private Double monthRise;
    /**
     * 近3个月
     **/
    private Double threeMonthsRise;
    /**
     * 近6个月
     **/
    private Double sixMonthsRise;
    /**
     * 近1年
     **/
    private Double oneYearRise;
    /**
     * 近2年
     **/
    private Double twoYearsRise;
    /**
     * 近3年
     **/
    private Double threeYearsRise;
    /**
     * 近1年
     **/
    private Double curYearRise;
    /**
     * 成立以来
     **/
    private Double historyRise;
    /**
     * 手续费
     **/
    private Double poundage;
    /**
     * 是否可以定投0no1ok
     **/
    private Integer dtStatus;
    /**
     * 交易状态
     **/
    private Integer dealStatus;
    /**
     * 行文本数据
     **/
    private String rowData;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getNetValue() {
        return netValue;
    }

    public void setNetValue(Double netValue) {
        this.netValue = netValue;
    }

    public Double getDayRise() {
        return dayRise;
    }

    public void setDayRise(Double dayRise) {
        this.dayRise = dayRise;
    }

    public Double getWeekRise() {
        return weekRise;
    }

    public void setWeekRise(Double weekRise) {
        this.weekRise = weekRise;
    }

    public Double getMonthRise() {
        return monthRise;
    }

    public void setMonthRise(Double monthRise) {
        this.monthRise = monthRise;
    }

    public Double getThreeMonthsRise() {
        return threeMonthsRise;
    }

    public void setThreeMonthsRise(Double threeMonthsRise) {
        this.threeMonthsRise = threeMonthsRise;
    }

    public Double getSixMonthsRise() {
        return sixMonthsRise;
    }

    public void setSixMonthsRise(Double sixMonthsRise) {
        this.sixMonthsRise = sixMonthsRise;
    }

    public Double getOneYearRise() {
        return oneYearRise;
    }

    public void setOneYearRise(Double oneYearRise) {
        this.oneYearRise = oneYearRise;
    }

    public Double getTwoYearsRise() {
        return twoYearsRise;
    }

    public void setTwoYearsRise(Double twoYearsRise) {
        this.twoYearsRise = twoYearsRise;
    }

    public Double getThreeYearsRise() {
        return threeYearsRise;
    }

    public void setThreeYearsRise(Double threeYearsRise) {
        this.threeYearsRise = threeYearsRise;
    }

    public Double getCurYearRise() {
        return curYearRise;
    }

    public void setCurYearRise(Double curYearRise) {
        this.curYearRise = curYearRise;
    }

    public Double getHistoryRise() {
        return historyRise;
    }

    public void setHistoryRise(Double historyRise) {
        this.historyRise = historyRise;
    }

    public Double getPoundage() {
        return poundage;
    }

    public void setPoundage(Double poundage) {
        this.poundage = poundage;
    }

    public Integer getDtStatus() {
        return dtStatus;
    }

    public void setDtStatus(Integer dtStatus) {
        this.dtStatus = dtStatus;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getRowData() {
        return rowData;
    }

    public void setRowData(String rowData) {
        this.rowData = rowData;
    }
}
