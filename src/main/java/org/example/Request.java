package org.example;

/**
 * Hello world!
 *
 */
public class Request
{
    private String name;
    private Data data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    static class Data {
        private int year;
        private double price;
        private String cpu_model;
        private String hard_disk_size;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getCpu_model() {
            return cpu_model;
        }

        public void setCpu_model(String cpu_model) {
            this.cpu_model = cpu_model;
        }

        public String getHard_disk_size() {
            return hard_disk_size;
        }

        public void setHard_disk_size(String hard_disk_size) {
            this.hard_disk_size = hard_disk_size;
        }
    }
}

