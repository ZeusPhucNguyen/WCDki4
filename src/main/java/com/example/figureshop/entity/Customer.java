package com.example.figureshop.entity;

import java.time.LocalDateTime;

public class Customer {
        private String CusId;
        private String fullName;
        private String phone;

        private String Image;
        private LocalDateTime dob;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private int status;

    public Customer(String cusId, String fullName, String phone, String Image, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.CusId = CusId;
        this.fullName = fullName;
        this.phone = phone;
        this.Image = Image;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Customer(String CusId, String fullName, String phone, String Image, LocalDateTime dob) {
        this.CusId = CusId;
        this.fullName = fullName;
        this.phone = phone;
        this.Image = Image;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer() {
        this.CusId = "";
        this.fullName = "";
        this.phone = "";
        this.Image = "";
    }

    public Customer(String CusId, String fullName, String phone, String Image) {
        this.CusId = CusId;
        this.fullName = fullName;
        this.phone = phone;
        this.Image = Image;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CusId='" + CusId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", Image='" + Image + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public String getCusId() {
        return CusId;
    }

    public void setCusId(String CusId) {
        this.CusId = CusId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getJoinedAt() {
        if(this.createdAt != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.createdAt);
        }
        return "";
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDemoString(){
        return "LOL,";
    }

    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }
}
