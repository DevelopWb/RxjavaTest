package com.rxjavatest.Test;

import java.util.List;

/**
 * Author:wang_sir
 * Time:2018/1/24 15:09
 * Description:This is Location
 */
public class Location {


    /**
     * Result : ok
     * Model : [{"Imei":"9106118032","OnTime":"2018-01-24 14:25:44","LineStatus":"离线","LocType":"GPS","Longitude":"116.3212","Latitude":"39.926083","BaseInfo":"无","Speed":"0.00","Direction":"正北","DeviceStatus":"静止|低电","Address":"北京市海淀区甘家口街道阜成路北二街北京工商大学(东区)"}]
     */

    private String Result;
    private List<ModelBean> Model;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public List<ModelBean> getModel() {
        return Model;
    }

    public void setModel(List<ModelBean> Model) {
        this.Model = Model;
    }

    public static class ModelBean {
        /**
         * Imei : 9106118032
         * OnTime : 2018-01-24 14:25:44
         * LineStatus : 离线
         * LocType : GPS
         * Longitude : 116.3212
         * Latitude : 39.926083
         * BaseInfo : 无
         * Speed : 0.00
         * Direction : 正北
         * DeviceStatus : 静止|低电
         * Address : 北京市海淀区甘家口街道阜成路北二街北京工商大学(东区)
         */

        private String Imei;
        private String OnTime;
        private String LineStatus;
        private String LocType;
        private String Longitude;
        private String Latitude;
        private String BaseInfo;
        private String Speed;
        private String Direction;
        private String DeviceStatus;
        private String Address;

        public String getImei() {
            return Imei;
        }

        public void setImei(String Imei) {
            this.Imei = Imei;
        }

        public String getOnTime() {
            return OnTime;
        }

        public void setOnTime(String OnTime) {
            this.OnTime = OnTime;
        }

        public String getLineStatus() {
            return LineStatus;
        }

        public void setLineStatus(String LineStatus) {
            this.LineStatus = LineStatus;
        }

        public String getLocType() {
            return LocType;
        }

        public void setLocType(String LocType) {
            this.LocType = LocType;
        }

        public String getLongitude() {
            return Longitude;
        }

        public void setLongitude(String Longitude) {
            this.Longitude = Longitude;
        }

        public String getLatitude() {
            return Latitude;
        }

        public void setLatitude(String Latitude) {
            this.Latitude = Latitude;
        }

        public String getBaseInfo() {
            return BaseInfo;
        }

        public void setBaseInfo(String BaseInfo) {
            this.BaseInfo = BaseInfo;
        }

        public String getSpeed() {
            return Speed;
        }

        public void setSpeed(String Speed) {
            this.Speed = Speed;
        }

        public String getDirection() {
            return Direction;
        }

        public void setDirection(String Direction) {
            this.Direction = Direction;
        }

        public String getDeviceStatus() {
            return DeviceStatus;
        }

        public void setDeviceStatus(String DeviceStatus) {
            this.DeviceStatus = DeviceStatus;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }
    }
}
