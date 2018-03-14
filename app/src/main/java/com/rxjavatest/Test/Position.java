package com.rxjavatest.Test;

/**
 * Author:wang_sir
 * Time:2018/1/24 14:08
 * Description:This is Position
 */
public class Position {


    /**
     * location : {"address":{"region":"海南省","county":"三亚市","street":"国营南新农场","street_number":"金鸡岭","city":"三亚市","country":"中国"},"addressDescription":"海南省三亚市三亚市金鸡路东五巷国营南新农场金鸡岭荔枝沟科技工贸园区西","longitude":109.49209,"latitude":18.28883,"accuracy":"1500"}
     * access_token : null
     * ErrCode : 0
     */

    private LocationBean location;
    private Object access_token;
    private String ErrCode;

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public Object getAccess_token() {
        return access_token;
    }

    public void setAccess_token(Object access_token) {
        this.access_token = access_token;
    }

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String ErrCode) {
        this.ErrCode = ErrCode;
    }

    public static class LocationBean {
        /**
         * address : {"region":"海南省","county":"三亚市","street":"国营南新农场","street_number":"金鸡岭","city":"三亚市","country":"中国"}
         * addressDescription : 海南省三亚市三亚市金鸡路东五巷国营南新农场金鸡岭荔枝沟科技工贸园区西
         * longitude : 109.49209
         * latitude : 18.28883
         * accuracy : 1500
         */

        private AddressBean address;
        private String addressDescription;
        private double longitude;
        private double latitude;
        private String accuracy;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public String getAddressDescription() {
            return addressDescription;
        }

        public void setAddressDescription(String addressDescription) {
            this.addressDescription = addressDescription;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(String accuracy) {
            this.accuracy = accuracy;
        }

        public static class AddressBean {
            /**
             * region : 海南省
             * county : 三亚市
             * street : 国营南新农场
             * street_number : 金鸡岭
             * city : 三亚市
             * country : 中国
             */

            private String region;
            private String county;
            private String street;
            private String street_number;
            private String city;
            private String country;

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreet_number() {
                return street_number;
            }

            public void setStreet_number(String street_number) {
                this.street_number = street_number;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }
        }
    }
}
