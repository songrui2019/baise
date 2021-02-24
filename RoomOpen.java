package org.cash.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.base.bean.JSONSerialize;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RoomOpen implements JSONSerialize {
	
	private Long id;
	private String batchNo = "";// 批次No
	private int clockType = 0;// 安排方式：1轮钟 2点钟 3call钟
	private String roomNo = "";// 房间编号
	private String cardNo = "";// 手牌号
	private String techUserNo = "";// 技师工号
	private Long techUserId;// 技师ID
	private Long workTimeId;//班次ID
	private String techUserNoWant = "";// 点钟的指定技师工号
	private int status = 0;// 状态
	private Long shopId = 0L;// 门店id
	private int sex = 0;// 性别
	private String projectNo = "";// 项目No
	private double projectPrice = 0;// 项目单价
	private int projectNum = 1;// 消费数量 默认1
	private double totalMoney;// 消费金额
	private double projectExtPrice = 0;// 项目加钟单价
	private int projectExtNum = 0;// 加钟消费数量 默认0
	private double extTotalMoney = 0;// 加钟消费金额 默认0
	private String projectCategoryCode = "";// 项目类型code
	private int buyRecord = 0;// 购买记录
	@JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
	private Date createTime;// 创建时间(发牌时间)
	@JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
	private Date assignTime;// 安排时间
	@JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
	private Date clockBeginTime;// 上钟时间
	@JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
	private Date clockEndTime;// 下钟时间
	@JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
	private Date clockExtBeginTime;// 最近一次加钟的时间
	private int blankTime = 0;// 分钟为单位,计算
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date payTime;// 支付时间
	private String workUserNo;// 工作人员的工号
	private int presentFlag = 0;// 是否赠送
	private int clockBeginWarnFlag = 0;// 上钟提醒
	private int clockEndWarnFlag = 0;// 下钟10分钟提醒
	private int clockFinishFlag = 0;// 服务结束提醒
	private int clockTimeOutFlag = 0;// 超时提醒
	private String oldBatchNo;//原批次
	private int advancePayStatus = 0;//预支付状态：0.没有预支付，1预支付，2结账
	private String advancePayBillNo;//预支付订单号
	private Integer missFlag = 0;// 漏钟的标记0未处理1有漏钟2没有漏钟
	private String clockRemark;//提前下钟备注
	private Integer releaseRoomFlag = 0;// 是否释放房间的标记，在没有结账的时候都可以是否房间
	private Long creditId = 0L;// 挂账表主键id
	private Date releaseRoomDate;// 房间释放时间
	private Long releaseRoomPerson;// 房间释放人员
	private int extraTimeFlag = 0;// 是否加班 1是0 否 
	private int suitFlag = 0;//0项目 1套餐 2套餐内的商品
	// pad端加钟能够选择其他项目，所以加次标记
	private int addClockFlag = 0;// 是否加钟 1是0 否
	private int bedNum = 0;// 床位数为0的时候表示开房是按房间计算费用，其他值则表示按床位计算费用
	private int turnOverFlag = 0;//用于指定时间为上钟记轮过一次，0没有记轮过 1记轮过
	private Long suitId;//套餐商品主键
	private int convertNum = 0;// 已兑换数量
	private int projectOldNum = 0;// 旧的数量
	private String scoreVipNo = "";// 积分会员号
	private String backUserIds = "";// 被更换的技师ID
	private String source;
	private Integer payFlag = 0; //0 表示没有提前结账 1表示提前结账
	@JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
	private Date assignTechTime;// 安排技师时间
	private Long workUserId;//'销售人id' 
	// 新增技师是否允许被预安排的属性
	private Integer releaseTechFlag = 0;// 1 一般用于下钟前5分钟
	private Integer preAssignFlag = 0;// 当值为1的时候，表示这条记录为预安排技师
	private int mp3Flag = 0;//是否已经生成调派语音标记 0没有声音语音 1已经生成语音
	private String oldProjectNo = "";// 项目No
	
	public static int Status_Send = 1;// 已发牌
	public static int Status_Assign = 2;// 已安排
	public static int Status_Clock = 3;// 已上钟
	public static int Status_ClockExt = 4;// 已加钟
	public static int Status_UsingRoom = 5;// 只开房
	public static int Status_SetMeal = 6;// 套餐
	public static int Status_Finish = 8;// 已下钟
	//public static int Status_Bill = 8;// 未下钟结账 ，保留账单
	public static int Status_Pay = 9;// 已结账
	public static int Status_ClockBack = 10;// 已退钟
	public static int Status_ClockCancel = 11;// 已取消安排

	// 非数据库字段
	private String actName = "";// 操作名称
	private String projectName = "";// 项目名称
	private String oldProjectName = "";// 项目名称
	private Long projectId;// 项目id
	private double actDiscountMoney = 0;// 营销活动折扣金额  动态计算
	private double vipDiscountMoney = 0d;// 会员折扣金额 动态计算
	private double otherDiscountMoney = 0d;// 其他价格类型折扣金额
	private double discountMoney = 0d;
	private double sysUnZeroMoney = 0d;
	private double projectOldPrice = 0;// 项目原始价格
	private double projectOldExtPrice = 0;// 项目原始加钟价格
	private String speechText = "";// 语音播报内容
	private String projectCategoryName = "";// 类别名称
	private String oldRoomNo = "";// 临时字段
	private int scoreConvert = 0;// 是否显示积分兑换 1是 0否
	private int convertFlag = 0;// 兑换标记
	
	private double advancePayMoney; //预支付金额
	private String payInfo;//预支付信息
	private Long priceType;//预支付价格类型
	private String vipNo;//预支付时填写的会员卡号
	private String warnUserNo;//异常操作授权人
	private String remark;//异常操作备注说明
	private int tmpSort;//临时排序
	private String categoryCode;//手牌类型
	private int cancelFlag = 0;//是否允许撤回上钟状态 0不允许 1允许
	private int rePayFlag;//是否是反结账状态
	private int clockFlag = 0;//技师下钟后指定时间内允许加钟  0不允许 1允许
	private int roomStatus = 0;// 用于标记退钟房态修改
	private double deductMoney = 0d;//商品提成
	private String shopName = "";
	private String waitTime = "";// 已等待时间
	private String techTime = "";// 还需等多久
	private String empNo = "";// 预约的技师工号
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	private Date deleteTime;// 删除时间
	private int time = 0;//上钟时间分钟（结束时间-开始时间）
	private int overTime = 0;//超时时间
	private String realName;
	private int stealtime = 0;//偷钟时间
	private String sexs = "";// 性别
	private String clockTypeName = "";
	private  int  projectTime = 0;//项目时长
	private  int  projectClockTime = 0;//项目加钟时长

	public int getRePayFlag() {
		return rePayFlag;
	}

	public void setRePayFlag(int rePayFlag) {
		this.rePayFlag = rePayFlag;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getCreateTime() {
		return createTime;
	}
	
	public String getCreateTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (createTime != null) {
			return fmt.format(createTime);
		}
		return "";
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTechUserNo() {
		return techUserNo;
	}

	public void setTechUserNo(String techUserNo) {
		this.techUserNo = techUserNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectCategoryCode() {
		return projectCategoryCode;
	}

	public void setProjectCategoryCode(String projectCategoryCode) {
		this.projectCategoryCode = projectCategoryCode;
	}

	public int getBuyRecord() {
		return buyRecord;
	}

	public void setBuyRecord(int buyRecord) {
		this.buyRecord = buyRecord;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getAssignTime() {
		return assignTime;
	}
	
	public String getAssignTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (assignTime != null) {
			return fmt.format(assignTime);
		}
		return "";
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

	public Date getClockBeginTime() {
		return clockBeginTime;
	}
	
	public String getClockBeginTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (clockBeginTime != null) {
			return fmt.format(clockBeginTime);
		}
		return "";
	}

	public void setClockBeginTime(Date clockBeginTime) {
		this.clockBeginTime = clockBeginTime;
	}

	public Date getClockEndTime() {
		return clockEndTime;
	}
	
	public String getClockEndTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (clockEndTime != null) {
			return fmt.format(clockEndTime);
		}
		return "";
	}

	public void setClockEndTime(Date clockEndTime) {
		this.clockEndTime = clockEndTime;
	}

	public Date getPayTime() {
		return payTime;
	}
	
	public String getPayTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (payTime != null) {
			return fmt.format(payTime);
		}
		return "";
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public int getClockType() {
		return clockType;
	}

	public void setClockType(int clockType) {
		this.clockType = clockType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getWorkUserNo() {
		return workUserNo;
	}

	public void setWorkUserNo(String workUserNo) {
		this.workUserNo = workUserNo;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(double projectPrice) {
		this.projectPrice = projectPrice;
	}

	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public double getProjectExtPrice() {
		return projectExtPrice;
	}

	public void setProjectExtPrice(double projectExtPrice) {
		this.projectExtPrice = projectExtPrice;
	}

	public int getProjectExtNum() {
		return projectExtNum;
	}

	public void setProjectExtNum(int projectExtNum) {
		this.projectExtNum = projectExtNum;
	}

	public double getExtTotalMoney() {
		return extTotalMoney;
	}

	public void setExtTotalMoney(double extTotalMoney) {
		this.extTotalMoney = extTotalMoney;
	}

	public double getActDiscountMoney() {
		return actDiscountMoney;
	}

	public void setActDiscountMoney(double actDiscountMoney) {
		this.actDiscountMoney = actDiscountMoney;
	}

	public double getVipDiscountMoney() {
		return vipDiscountMoney;
	}

	public void setVipDiscountMoney(double vipDiscountMoney) {
		this.vipDiscountMoney = vipDiscountMoney;
	}

	public int getPresentFlag() {
		return presentFlag;
	}

	public void setPresentFlag(int presentFlag) {
		this.presentFlag = presentFlag;
	}

	public double getProjectOldPrice() {
		return projectOldPrice;
	}

	public void setProjectOldPrice(double projectOldPrice) {
		this.projectOldPrice = projectOldPrice;
	}

	public String getSpeechText() {
		return speechText;
	}

	public void setSpeechText(String speechText) {
		this.speechText = speechText;
	}

	public int getClockBeginWarnFlag() {
		return clockBeginWarnFlag;
	}

	public void setClockBeginWarnFlag(int clockBeginWarnFlag) {
		this.clockBeginWarnFlag = clockBeginWarnFlag;
	}

	public int getClockEndWarnFlag() {
		return clockEndWarnFlag;
	}

	public void setClockEndWarnFlag(int clockEndWarnFlag) {
		this.clockEndWarnFlag = clockEndWarnFlag;
	}

	public String getTechUserNoWant() {
		return techUserNoWant;
	}

	public void setTechUserNoWant(String techUserNoWant) {
		this.techUserNoWant = techUserNoWant;
	}

	public String getProjectCategoryName() {
		return projectCategoryName;
	}

	public void setProjectCategoryName(String projectCategoryName) {
		this.projectCategoryName = projectCategoryName;
	}

	public int getClockFinishFlag() {
		return clockFinishFlag;
	}

	public void setClockFinishFlag(int clockFinishFlag) {
		this.clockFinishFlag = clockFinishFlag;
	}

	public Long getTechUserId() {
		return techUserId;
	}

	public void setTechUserId(Long techUserId) {
		this.techUserId = techUserId;
	}

	public Long getWorkTimeId() {
		return workTimeId;
	}

	public void setWorkTimeId(Long workTimeId) {
		this.workTimeId = workTimeId;
	}

	public String getOldBatchNo() {
		return oldBatchNo;
	}

	public void setOldBatchNo(String oldBatchNo) {
		this.oldBatchNo = oldBatchNo;
	}

	public int getAdvancePayStatus() {
		return advancePayStatus;
	}

	public void setAdvancePayStatus(int advancePayStatus) {
		this.advancePayStatus = advancePayStatus;
	}

	public String getAdvancePayBillNo() {
		if (advancePayBillNo == null) {
			return "";
		}
		return advancePayBillNo;
	}

	public void setAdvancePayBillNo(String advancePayBillNo) {
		this.advancePayBillNo = advancePayBillNo;
	}

	public double getAdvancePayMoney() {
		return advancePayMoney;
	}

	public void setAdvancePayMoney(double advancePayMoney) {
		this.advancePayMoney = advancePayMoney;
	}

	public String getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}

	public Long getPriceType() {
		return priceType;
	}

	public void setPriceType(Long priceType) {
		this.priceType = priceType;
	}

	public String getVipNo() {
		return vipNo;
	}

	public void setVipNo(String vipNo) {
		this.vipNo = vipNo;
	}

	public String getOldRoomNo() {
		return oldRoomNo;
	}

	public void setOldRoomNo(String oldRoomNo) {
		this.oldRoomNo = oldRoomNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getClockExtBeginTime() {
		return clockExtBeginTime;
	}
	
	public String getClockExtBeginTimeStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (clockExtBeginTime != null) {
			return fmt.format(clockExtBeginTime);
		}
		return "";
	}

	public void setClockExtBeginTime(Date clockExtBeginTime) {
		this.clockExtBeginTime = clockExtBeginTime;
	}

	public int getBlankTime() {
		return blankTime;
	}

	public void setBlankTime(int blankTime) {
		this.blankTime = blankTime;
	}

	public Integer getMissFlag() {
		return missFlag;
	}

	public void setMissFlag(Integer missFlag) {
		this.missFlag = missFlag;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getClockRemark() {
		return clockRemark;
	}

	public void setClockRemark(String clockRemark) {
		this.clockRemark = clockRemark;
	}

	public double getProjectOldExtPrice() {
		return projectOldExtPrice;
	}

	public void setProjectOldExtPrice(double projectOldExtPrice) {
		this.projectOldExtPrice = projectOldExtPrice;
	}

	public Integer getReleaseRoomFlag() {
		return releaseRoomFlag;
	}

	public void setReleaseRoomFlag(Integer releaseRoomFlag) {
		this.releaseRoomFlag = releaseRoomFlag;
	}

	public int getExtraTimeFlag() {
		return extraTimeFlag;
	}

	public void setExtraTimeFlag(int extraTimeFlag) {
		this.extraTimeFlag = extraTimeFlag;
	}

	public Date getReleaseRoomDate() {
		return releaseRoomDate;
	}
	
	public String getReleaseRoomDateStr() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (releaseRoomDate != null) {
			return fmt.format(releaseRoomDate);
		}
		return "";
	}

	public void setReleaseRoomDate(Date releaseRoomDate) {
		this.releaseRoomDate = releaseRoomDate;
	}

	public Long getReleaseRoomPerson() {
		return releaseRoomPerson;
	}

	public void setReleaseRoomPerson(Long releaseRoomPerson) {
		this.releaseRoomPerson = releaseRoomPerson;
	}

	public int getSuitFlag() {
		return suitFlag;
	}

	public void setSuitFlag(int suitFlag) {
		this.suitFlag = suitFlag;
	}
	
	public int getAddClockFlag() {
		return addClockFlag;
	}

	public void setAddClockFlag(int addClockFlag) {
		this.addClockFlag = addClockFlag;
	}

	public int getBedNum() {
		return bedNum;
	}

	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
	public int getTmpSort() {
		return tmpSort;
	}

	public void setTmpSort(int tmpSort) {
		this.tmpSort = tmpSort;
	}
	
	public String getWarnUserNo() {
		return warnUserNo;
	}

	public void setWarnUserNo(String warnUserNo) {
		this.warnUserNo = warnUserNo;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public int getTurnOverFlag() {
		return turnOverFlag;
	}

	public void setTurnOverFlag(int turnOverFlag) {
		this.turnOverFlag = turnOverFlag;
	}

	public double getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(double discountMoney) {
		this.discountMoney = discountMoney;
	}

	public double getSysUnZeroMoney() {
		return sysUnZeroMoney;
	}

	public void setSysUnZeroMoney(double sysUnZeroMoney) {
		this.sysUnZeroMoney = sysUnZeroMoney;
	}
	
	public Long getSuitId() {
		return suitId;
	}
	
	public void setSuitId(Long suitId) {
		this.suitId = suitId;
	}

	public int getClockFlag() {
		return clockFlag;
	}

	public void setClockFlag(int clockFlag) {
		this.clockFlag = clockFlag;
	}

	public int getScoreConvert() {
		return scoreConvert;
	}

	public void setScoreConvert(int scoreConvert) {
		this.scoreConvert = scoreConvert;
	}

	public int getConvertFlag() {
		return convertFlag;
	}

	public void setConvertFlag(int convertFlag) {
		this.convertFlag = convertFlag;
	}

	public int getConvertNum() {
		return convertNum;
	}

	public void setConvertNum(int convertNum) {
		this.convertNum = convertNum;
	}

	public int getProjectOldNum() {
		return projectOldNum;
	}

	public void setProjectOldNum(int projectOldNum) {
		this.projectOldNum = projectOldNum;
	}

	public String getScoreVipNo() {
		return scoreVipNo;
	}

	public void setScoreVipNo(String scoreVipNo) {
		this.scoreVipNo = scoreVipNo;
	}

	public String getBackUserIds() {
		return backUserIds;
	}

	public void setBackUserIds(String backUserIds) {
		this.backUserIds = backUserIds;
	}

	public int getClockTimeOutFlag() {
		return clockTimeOutFlag;
	}

	public void setClockTimeOutFlag(int clockTimeOutFlag) {
		this.clockTimeOutFlag = clockTimeOutFlag;
	}

	public int getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}
	
	public double getDeductMoney() {
		return deductMoney;
	}

	public void setDeductMoney(double deductMoney) {
		this.deductMoney = deductMoney;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getTechTime() {
		return techTime;
	}

	public void setTechTime(String techTime) {
		this.techTime = techTime;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getPayFlag() {
		return payFlag;
	}

	public void setPayFlag(Integer payFlag) {
		this.payFlag = payFlag;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getStealtime() {
		return stealtime;
	}

	public void setStealtime(int stealtime) {
		this.stealtime = stealtime;
	}

	public Long getCreditId() {
		return creditId;
	}

	public void setCreditId(Long creditId) {
		this.creditId = creditId;
	}

	public String getSexs() {
		if (sex == 0) {
			sexs = "不限";
		} else if (sex == 1) {
			sexs = "男";
		} else if (sex == 2) {
			sexs = "女";
		} 
		return sexs;
	}

	public void setSexs(String sexs) {
		this.sexs = sexs;
	}

	public double getOtherDiscountMoney() {
		return otherDiscountMoney;
	}

	public void setOtherDiscountMoney(double otherDiscountMoney) {
		this.otherDiscountMoney = otherDiscountMoney;
	}
	
	public Date getAssignTechTime() {
		return assignTechTime;
	}

	public void setAssignTechTime(Date assignTechTime) {
		this.assignTechTime = assignTechTime;
	}

	public Long getWorkUserId() {
		return workUserId;
	}

	public void setWorkUserId(Long workUserId) {
		this.workUserId = workUserId;
	}

	public Integer getReleaseTechFlag() {
		return releaseTechFlag;
	}

	public void setReleaseTechFlag(Integer releaseTechFlag) {
		this.releaseTechFlag = releaseTechFlag;
	}

	public Integer getPreAssignFlag() {
		return preAssignFlag;
	}

	public void setPreAssignFlag(Integer preAssignFlag) {
		this.preAssignFlag = preAssignFlag;
	}

	public String getClockTypeName() {
		if (extraTimeFlag == 0) {
			if (addClockFlag == 0) {
				if (clockType == 1) {
					clockTypeName = "轮钟";
				} else if (clockType == 2) {
					clockTypeName = "点钟";
				} else if (clockType == 3) {
					clockTypeName = "call钟";
				}
			} else {
				clockTypeName = "加钟";
			}
		} else {
			if (addClockFlag == 0) {
				if (clockType == 1) {
					clockTypeName = "轮钟加班";
				} else if (clockType == 2) {
					clockTypeName = "点钟加班";
				} else if (clockType == 3) {
					clockTypeName = "call钟加班";
				}
			} else {
				clockTypeName = "加钟加班";
			}
		}
		return clockTypeName;
	}

	public int getMp3Flag() {
		return mp3Flag;
	}

	public void setMp3Flag(int mp3Flag) {
		this.mp3Flag = mp3Flag;
	}

	public int getProjectTime() {
		return projectTime;
	}

	public void setProjectTime(int projectTime) {
		this.projectTime = projectTime;
	}

	public int getProjectClockTime() {
		return projectClockTime;
	}

	public void setProjectClockTime(int projectClockTime) {
		this.projectClockTime = projectClockTime;
	}

	public String getOldProjectNo() {
		return oldProjectNo;
	}

	public void setOldProjectNo(String oldProjectNo) {
		this.oldProjectNo = oldProjectNo;
	}

	public String getOldProjectName() {
		return oldProjectName;
	}

	public void setOldProjectName(String oldProjectName) {
		this.oldProjectName = oldProjectName;
	}
	
	
	
	
}	
