package com.upgrad.hirewheels.service;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("InitService")
public class InitServiceImpl implements InitService {

    @Autowired
    UserRoleDAO userRoleDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    VehicleCategoryDAO vehicleCategoryDAO;
    @Autowired
    VehicleSubCategoryDAO vehicleSubCategoryDAO;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    FuelTypeDAO fuelTypeDAO;
    @Autowired
    LocationDAO locationDAO;

    public void start() {
        insertrole();
        insertusers();
        insertvehicle_category();
        insertvehicle_subcategory();
        insertcity();
        insertfuel_type();
        insertlocation();
    }

    private void insertrole() {
        UserRole adminUserRole = new UserRole();
        adminUserRole.setRoleId(1);
        adminUserRole.setRoleName("Admin");
        UserRole userRole = new UserRole();
        userRole.setRoleId(2);
        userRole.setRoleName("User");
        userRoleDAO.save(adminUserRole);
        userRoleDAO.save(userRole);
    }

    private void insertusers() {
        User User = new User();
        User.setFirstName("Upgrad");
        User.setLastName("Admim");
        User.setEmail("upgrad@gmail.com");
        User.setMobileNo("9898989890");
        User.setPassword("admin@123");
        User.setWalletMoney(10000);
        User.setUserRole(userRoleDAO.findByRoleId(1));
        userDAO.save(User);
    }

    private void insertvehicle_category() {
        List<VehicleCategory> vehicleCategoryList = new ArrayList<>();
        VehicleCategory vehicleCategory1 = new VehicleCategory();
        vehicleCategory1.setVehicleCategoryId(10);
        vehicleCategory1.setVehicleCategoryName("CAR");
        vehicleCategoryList.add(vehicleCategory1);


        VehicleCategory vehicleCategory2 = new VehicleCategory();
        vehicleCategory2.setVehicleCategoryId(11);
        vehicleCategory2.setVehicleCategoryName("BIKE");
        vehicleCategoryList.add(vehicleCategory2);
        vehicleCategoryDAO.saveAll(vehicleCategoryList);
    }

    private void insertvehicle_subcategory() {
        VehicleSubCategory vehicleSubCategory1 = new VehicleSubCategory();
        vehicleSubCategory1.setVehicleSubCategoryId(1);
        vehicleSubCategory1.setVehicleSubCategoryName("SUV");
        vehicleSubCategory1.setPricePerHour(300);
        vehicleSubCategory1.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategoryDAO.save(vehicleSubCategory1);


        VehicleSubCategory vehicleSubCategory2 = new VehicleSubCategory();
        vehicleSubCategory2.setVehicleSubCategoryId(2);
        vehicleSubCategory2.setVehicleSubCategoryName("SEDAN");
        vehicleSubCategory2.setPricePerHour(350);
        vehicleSubCategory2.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategoryDAO.save(vehicleSubCategory2);


        VehicleSubCategory vehicleSubCategory3 = new VehicleSubCategory();
        vehicleSubCategory3.setVehicleSubCategoryId(3);
        vehicleSubCategory3.setVehicleSubCategoryName("HATCHBACK");
        vehicleSubCategory3.setPricePerHour(250);
        vehicleSubCategory3.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(10));
        vehicleSubCategoryDAO.save(vehicleSubCategory3);


        VehicleSubCategory vehicleSubCategory4 = new VehicleSubCategory();
        vehicleSubCategory4.setVehicleSubCategoryId(4);
        vehicleSubCategory4.setVehicleSubCategoryName("CRUISER");
        vehicleSubCategory4.setPricePerHour(200);
        vehicleSubCategory4.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategoryDAO.save(vehicleSubCategory4);


        VehicleSubCategory vehicleSubCategory5 = new VehicleSubCategory();
        vehicleSubCategory5.setVehicleSubCategoryId(5);
        vehicleSubCategory5.setVehicleSubCategoryName("DIRT BIKE");
        vehicleSubCategory5.setPricePerHour(200);
        vehicleSubCategory5.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategoryDAO.save(vehicleSubCategory5);


        VehicleSubCategory vehicleSubCategory6 = new VehicleSubCategory();
        vehicleSubCategory6.setVehicleSubCategoryId(6);
        vehicleSubCategory6.setVehicleSubCategoryName("SPORTS BIKE");
        vehicleSubCategory6.setPricePerHour(150);
        vehicleSubCategory6.setVehicleCategory(vehicleCategoryDAO.findByVehicleCategoryId(11));
        vehicleSubCategoryDAO.save(vehicleSubCategory6);
    }

    private void insertcity() {
        City city = new City();
        city.setCityId(1);
        city.setCityName("Mumbai");
        cityDAO.save(city);
    }

    private void insertfuel_type() {
        List<FuelType> fuelTypeList = new ArrayList<>();
        FuelType fuelType1 = new FuelType();
        fuelType1.setFuelType("Petrol");
        fuelType1.setFuelTypeId(1);
        fuelTypeList.add(fuelType1);
        FuelType fuelType2 = new FuelType();
        fuelType2.setFuelType("Diesel");
        fuelType2.setFuelTypeId(2);
        fuelTypeList.add(fuelType2);
        fuelTypeDAO.saveAll(fuelTypeList);
    }

    private void insertlocation() {
        Location location = new Location();
        location.setLocationId(1);
        location.setLocationName("Worli");
        location.setAddress("Dr E Moses Rd, Worli Naka, Upper Worli");
        location.setPincode(400018);
        location.setCity(cityDAO.findById(1).get());
        locationDAO.save(location);

        Location location2 = new Location();
        location2.setLocationId(2);
        location2.setLocationName("Chembur");
        location2.setAddress("Oplic Complex");
        location2.setPincode(400018);
        location2.setCity(cityDAO.findById(1).get());
        locationDAO.save(location2);

        Location location3 = new Location();
        location3.setLocationId(3);
        location3.setLocationName("Powai");
        location3.setAddress("Hiranandani Tower");
        location3.setPincode(400018);
        location3.setCity(cityDAO.findById(1).get());
        locationDAO.save(location3);
    }
}
