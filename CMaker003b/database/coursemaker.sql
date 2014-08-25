SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `coursemaker` ;
CREATE SCHEMA IF NOT EXISTS `coursemaker` DEFAULT CHARACTER SET latin1 ;
USE `coursemaker` ;

-- -----------------------------------------------------
-- Table `coursemaker`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`country` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`country` (
  `countryID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `countryName` VARCHAR(100) NULL DEFAULT NULL ,
  `latitude` DOUBLE NULL DEFAULT NULL ,
  `longitude` DOUBLE NULL DEFAULT NULL ,
  `countryCode` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`countryID`) ,
  UNIQUE INDEX `index2` (`countryName` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`province`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`province` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`province` (
  `provinceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `countryID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `provinceName` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`provinceID`) ,
  UNIQUE INDEX `index3` (`countryID` ASC, `provinceName` ASC) ,
  INDEX `ix88` (`countryID` ASC) ,
  INDEX `fg008` (`countryID` ASC) ,
  CONSTRAINT `province_ibfk_1`
    FOREIGN KEY (`countryID` )
    REFERENCES `coursemaker`.`country` (`countryID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`city` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`city` (
  `cityID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `provinceID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `cityName` VARCHAR(100) NULL DEFAULT NULL ,
  `latitude` DOUBLE NULL DEFAULT NULL ,
  `longitude` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`cityID`) ,
  UNIQUE INDEX `index3` (`provinceID` ASC, `cityName` ASC) ,
  INDEX `ix550` (`provinceID` ASC) ,
  INDEX `fk550` (`provinceID` ASC) ,
  CONSTRAINT `fk550`
    FOREIGN KEY (`provinceID` )
    REFERENCES `coursemaker`.`province` (`provinceID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 285
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`company`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`company` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`company` (
  `companyID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `companyName` VARCHAR(100) NOT NULL ,
  `email` VARCHAR(100) NULL DEFAULT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `cityID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`companyID`) ,
  UNIQUE INDEX `index4` (`cityID` ASC, `companyName` ASC) ,
  INDEX `ixb01` (`cityID` ASC) ,
  INDEX `fkb01` (`cityID` ASC) ,
  CONSTRAINT `fkb01`
    FOREIGN KEY (`cityID` )
    REFERENCES `coursemaker`.`city` (`cityID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`category` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`category` (
  `categoryID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `categoryName` VARCHAR(50) NOT NULL ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `localID` BIGINT(20) NULL DEFAULT NULL ,
  `syncDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`categoryID`) ,
  UNIQUE INDEX `idxs0` (`companyID` ASC, `categoryName` ASC) ,
  INDEX `fks2` (`companyID` ASC) ,
  CONSTRAINT `category_ibfk_1`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`course` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`course` (
  `courseID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  `activeFlag` INT(11) NULL DEFAULT NULL ,
  `categoryID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `courseName` VARCHAR(255) NULL DEFAULT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `shareFlag` INT(11) NULL DEFAULT NULL ,
  `localID` BIGINT(20) NULL DEFAULT NULL ,
  `syncDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`courseID`) ,
  UNIQUE INDEX `index6aa` (`companyID` ASC, `courseName` ASC) ,
  INDEX `ixd90` (`companyID` ASC) ,
  INDEX `fkd90` (`companyID` ASC) ,
  INDEX `index4` (`categoryID` ASC) ,
  INDEX `fkd91` (`categoryID` ASC) ,
  CONSTRAINT `fkd90`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkd91`
    FOREIGN KEY (`categoryID` )
    REFERENCES `coursemaker`.`category` (`categoryID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`activity` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`activity` (
  `activityID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `activityName` VARCHAR(255) NOT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `courseID` INT(10) UNSIGNED NOT NULL ,
  `priorityFlag` INT(11) NULL DEFAULT NULL ,
  `localID` BIGINT(20) NULL DEFAULT NULL ,
  `syncDate` DATETIME NULL DEFAULT NULL ,
  `durationInDays` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`activityID`) ,
  INDEX `ix011` (`courseID` ASC) ,
  INDEX `fxsds` (`courseID` ASC) ,
  CONSTRAINT `fxsds`
    FOREIGN KEY (`courseID` )
    REFERENCES `coursemaker`.`course` (`courseID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 114
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`administrator`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`administrator` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`administrator` (
  `administratorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `firstName` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `cellphone` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `activeFlag` INT(11) NULL DEFAULT NULL ,
  `superUserFlag` INT(11) NULL DEFAULT NULL ,
  `GCMRegistrationID` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`administratorID`) ,
  UNIQUE INDEX `index4` (`email` ASC) ,
  INDEX `ixtx00` (`companyID` ASC) ,
  INDEX `fktcx00` (`companyID` ASC) ,
  CONSTRAINT `fktcx00`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`trainingClass`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`trainingClass` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`trainingClass` (
  `trainingClassID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `trainingClassName` VARCHAR(100) NOT NULL ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `startDate` DATETIME NOT NULL ,
  `endDate` DATETIME NOT NULL ,
  `administratorID` INT(10) UNSIGNED NOT NULL ,
  `isOpen` INT(11) NULL DEFAULT NULL ,
  `calendarID` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`trainingClassID`) ,
  INDEX `fktcc` (`companyID` ASC) ,
  INDEX `fk1ad` (`administratorID` ASC) ,
  INDEX `fktrcla` (`administratorID` ASC) ,
  INDEX `ixtcc` (`companyID` ASC, `trainingClassName` ASC) ,
  CONSTRAINT `trainingClass_ibfk_1`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE,
  CONSTRAINT `trainingClass_ibfk_2`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 30
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`institution`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`institution` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`institution` (
  `institutionID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `institutionName` VARCHAR(100) NOT NULL ,
  `cityID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`institutionID`) ,
  INDEX `fkcit` (`cityID` ASC) ,
  CONSTRAINT `institution_ibfk_1`
    FOREIGN KEY (`cityID` )
    REFERENCES `coursemaker`.`city` (`cityID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`trainee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`trainee` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`trainee` (
  `traineeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(45) NOT NULL ,
  `middleName` VARCHAR(45) NULL DEFAULT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `cellphone` VARCHAR(45) NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `gender` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `institutionID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `companyID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `IDNumber` VARCHAR(45) NULL DEFAULT NULL ,
  `address` VARCHAR(255) NULL DEFAULT NULL ,
  `cityID` INT(10) UNSIGNED NOT NULL ,
  `trainingClassID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `activeFlag` INT(11) NULL DEFAULT NULL ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `GCMRegistrationID` TEXT NULL DEFAULT NULL ,
  `dateUpdated` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`traineeID`) ,
  UNIQUE INDEX `email` (`email` ASC) ,
  INDEX `ix004` (`institutionID` ASC) ,
  INDEX `fk004` (`institutionID` ASC) ,
  INDEX `fk004a` (`companyID` ASC) ,
  INDEX `ix004C` (`cityID` ASC) ,
  INDEX `fk004c` (`cityID` ASC) ,
  INDEX `ix004D` (`trainingClassID` ASC) ,
  INDEX `fk004D` (`trainingClassID` ASC) ,
  INDEX `ix004ff` (`administratorID` ASC) ,
  INDEX `fk004xx` (`administratorID` ASC) ,
  CONSTRAINT `trainee_ibfk_1`
    FOREIGN KEY (`institutionID` )
    REFERENCES `coursemaker`.`institution` (`institutionID` )
    ON DELETE RESTRICT,
  CONSTRAINT `trainee_ibfk_2`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE,
  CONSTRAINT `trainee_ibfk_3`
    FOREIGN KEY (`cityID` )
    REFERENCES `coursemaker`.`city` (`cityID` )
    ON DELETE RESTRICT,
  CONSTRAINT `trainee_ibfk_4`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE RESTRICT,
  CONSTRAINT `trainee_ibfk_5`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 152
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`attendance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`attendance` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`attendance` (
  `attendanceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `trainingClassID` INT(10) UNSIGNED NOT NULL ,
  `checkInDate` DATETIME NOT NULL ,
  `checkOutDate` DATETIME NOT NULL ,
  `checkInLatitude` DOUBLE NULL DEFAULT NULL ,
  `checkInLongitude` DOUBLE NULL DEFAULT NULL ,
  `checkOutLatitude` DOUBLE NULL DEFAULT NULL ,
  `checkOutLongitude` DOUBLE NULL DEFAULT NULL ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`attendanceID`) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  CONSTRAINT `attendance_ibfk_1`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` ),
  CONSTRAINT `attendance_ibfk_2`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`author` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`author` (
  `authorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(45) NULL DEFAULT NULL ,
  `lastName` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NULL DEFAULT NULL ,
  `cellphone` VARCHAR(45) NULL DEFAULT NULL ,
  `dateRegistered` DATETIME NULL DEFAULT NULL ,
  `companyID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `activeFlag` INT(11) NULL DEFAULT NULL ,
  `GCMRegistrationID` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`authorID`) ,
  UNIQUE INDEX `email` (`email` ASC) ,
  INDEX `index2` (`companyID` ASC) ,
  INDEX `fgcv` (`companyID` ASC) ,
  CONSTRAINT `fgcv`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`courseAuthor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`courseAuthor` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`courseAuthor` (
  `courseAuthorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseID` INT(10) UNSIGNED NOT NULL ,
  `authorID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  PRIMARY KEY (`courseAuthorID`) ,
  UNIQUE INDEX `index6` (`courseID` ASC, `authorID` ASC) ,
  INDEX `zx77` (`courseID` ASC) ,
  INDEX `fk78` (`authorID` ASC) ,
  INDEX `index5` (`authorID` ASC) ,
  INDEX `fk7878` (`courseID` ASC) ,
  CONSTRAINT `fk78`
    FOREIGN KEY (`authorID` )
    REFERENCES `coursemaker`.`author` (`authorID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk7878`
    FOREIGN KEY (`courseID` )
    REFERENCES `coursemaker`.`course` (`courseID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`trainingClassCourse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`trainingClassCourse` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`trainingClassCourse` (
  `trainingClassCourseID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseID` INT(10) UNSIGNED NOT NULL ,
  `trainingClassID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NULL DEFAULT NULL ,
  `priorityFlag` INT(11) NULL DEFAULT NULL ,
  `startDate` DATETIME NULL DEFAULT NULL ,
  `endDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`trainingClassCourseID`) ,
  UNIQUE INDEX `trainingClassID` (`trainingClassID` ASC, `courseID` ASC) ,
  INDEX `ixop` (`courseID` ASC) ,
  INDEX `ixop2` (`trainingClassID` ASC) ,
  INDEX `fkop` (`courseID` ASC) ,
  CONSTRAINT `trainingClassCourse_ibfk_1`
    FOREIGN KEY (`courseID` )
    REFERENCES `coursemaker`.`course` (`courseID` )
    ON DELETE CASCADE,
  CONSTRAINT `trainingClassCourse_ibfk_2`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 85
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`rating` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`rating` (
  `ratingID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ratingName` VARCHAR(50) NULL DEFAULT NULL ,
  `ratingNumber` INT(11) NULL DEFAULT NULL ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`ratingID`) ,
  UNIQUE INDEX `ix211` (`ratingName` ASC) ,
  INDEX `companyID` (`companyID` ASC) ,
  CONSTRAINT `rating_ibfk_1`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`courseTrainee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`courseTrainee` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`courseTrainee` (
  `courseTraineeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `trainingClassCourseID` INT(10) UNSIGNED NOT NULL ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `dateEnrolled` DATETIME NOT NULL ,
  `ratingID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `ratingDate` DATETIME NULL DEFAULT NULL ,
  `comment` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`courseTraineeID`) ,
  UNIQUE INDEX `ix016` (`trainingClassCourseID` ASC, `traineeID` ASC) ,
  INDEX `ix012` (`trainingClassCourseID` ASC) ,
  INDEX `ix013` (`traineeID` ASC) ,
  INDEX `fk012` (`trainingClassCourseID` ASC) ,
  INDEX `fk014` (`traineeID` ASC) ,
  INDEX `ix015` (`dateEnrolled` ASC) ,
  INDEX `ix014` (`ratingID` ASC) ,
  INDEX `fk015` (`ratingID` ASC) ,
  CONSTRAINT `courseTrainee_ibfk_1`
    FOREIGN KEY (`trainingClassCourseID` )
    REFERENCES `coursemaker`.`trainingClassCourse` (`trainingClassCourseID` )
    ON DELETE CASCADE,
  CONSTRAINT `courseTrainee_ibfk_2`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `courseTrainee_ibfk_3`
    FOREIGN KEY (`ratingID` )
    REFERENCES `coursemaker`.`rating` (`ratingID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 791
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`courseTraineeActivity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`courseTraineeActivity` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`courseTraineeActivity` (
  `courseTraineeActivityID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseTraineeID` INT(10) UNSIGNED NOT NULL ,
  `activityID` INT(10) UNSIGNED NOT NULL ,
  `ratingID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `completedFlag` INT(11) NULL DEFAULT NULL ,
  `comment` TEXT NULL DEFAULT NULL ,
  `dateUpdated` DATETIME NULL DEFAULT NULL ,
  `completionDate` DATETIME NULL DEFAULT NULL ,
  `refreshRequested` INT(11) NULL DEFAULT NULL ,
  `completionPercentage` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`courseTraineeActivityID`) ,
  INDEX `ix020` (`courseTraineeID` ASC) ,
  INDEX `ix021` (`activityID` ASC) ,
  INDEX `fk020` (`activityID` ASC) ,
  INDEX `fk021` (`courseTraineeID` ASC) ,
  INDEX `ix022` (`ratingID` ASC) ,
  INDEX `fk022` (`ratingID` ASC) ,
  CONSTRAINT `courseTraineeActivity_ibfk_1`
    FOREIGN KEY (`courseTraineeID` )
    REFERENCES `coursemaker`.`courseTrainee` (`courseTraineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `courseTraineeActivity_ibfk_2`
    FOREIGN KEY (`activityID` )
    REFERENCES `coursemaker`.`activity` (`activityID` )
    ON DELETE CASCADE,
  CONSTRAINT `courseTraineeActivity_ibfk_3`
    FOREIGN KEY (`ratingID` )
    REFERENCES `coursemaker`.`rating` (`ratingID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 29354
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`team` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`team` (
  `teamID` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `teamName` VARCHAR(255) NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `trainingClassID` INT(11) UNSIGNED NOT NULL ,
  PRIMARY KEY (`teamID`) ,
  UNIQUE INDEX `trainingClassID_2` (`trainingClassID` ASC, `teamName` ASC) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  CONSTRAINT `team_ibfk_1`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`demoAnnouncement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`demoAnnouncement` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`demoAnnouncement` (
  `demoAnnouncementID` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `demoDate` DATETIME NOT NULL ,
  `teamID` INT(11) UNSIGNED NULL DEFAULT NULL ,
  `traineeID` INT(11) UNSIGNED NULL DEFAULT NULL ,
  `trainingClassID` INT(11) UNSIGNED NOT NULL ,
  `dateRequested` DATETIME NOT NULL ,
  `description` TEXT NOT NULL ,
  `cancellationDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`demoAnnouncementID`) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  INDEX `teamID` (`teamID` ASC) ,
  CONSTRAINT `demoAnnouncement_ibfk_1`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE,
  CONSTRAINT `demoAnnouncement_ibfk_2`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `demoAnnouncement_ibfk_3`
    FOREIGN KEY (`teamID` )
    REFERENCES `coursemaker`.`team` (`teamID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`equipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`equipment` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`equipment` (
  `equipmentID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `equipmentName` VARCHAR(100) NULL DEFAULT NULL ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`equipmentID`) ,
  UNIQUE INDEX `companyID` (`companyID` ASC, `equipmentName` ASC) ,
  INDEX `index3` (`companyID` ASC) ,
  INDEX `fktrc` (`companyID` ASC) ,
  INDEX `index5` (`administratorID` ASC) ,
  INDEX `jkad` (`administratorID` ASC) ,
  CONSTRAINT `equipment_ibfk_1`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE,
  CONSTRAINT `equipment_ibfk_2`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 113
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`errorStore`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`errorStore` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`errorStore` (
  `errorStoreID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `statusCode` INT(11) NOT NULL ,
  `message` TEXT NOT NULL ,
  `dateOccured` DATETIME NOT NULL ,
  `origin` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`errorStoreID`) ,
  INDEX `dateOccured` (`dateOccured` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 847
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`instructor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`instructor` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`instructor` (
  `instructorID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(45) NOT NULL ,
  `lastName` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `cellphone` VARCHAR(45) NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `cityID` INT(10) UNSIGNED NOT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `activeFlag` INT(11) NULL DEFAULT NULL ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `GCMRegistrationID` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`instructorID`) ,
  UNIQUE INDEX `index6` (`email` ASC) ,
  INDEX `ixc09` (`cityID` ASC) ,
  INDEX `fkc09` (`cityID` ASC) ,
  INDEX `ixc010` (`companyID` ASC) ,
  INDEX `fkc010` (`companyID` ASC) ,
  INDEX `ix09p` (`administratorID` ASC) ,
  INDEX `fkc011x` (`administratorID` ASC) ,
  CONSTRAINT `instructor_ibfk_1`
    FOREIGN KEY (`cityID` )
    REFERENCES `coursemaker`.`city` (`cityID` )
    ON DELETE RESTRICT,
  CONSTRAINT `instructor_ibfk_2`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE,
  CONSTRAINT `instructor_ibfk_3`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`reportUser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`reportUser` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`reportUser` (
  `reportUserID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `firstName` VARCHAR(45) NULL DEFAULT NULL ,
  `lastName` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  `cellphone` VARCHAR(45) NULL DEFAULT NULL ,
  `dateRegistered` DATETIME NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  `GCMRegistrationID` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`reportUserID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`gcmDevice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`gcmDevice` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`gcmDevice` (
  `gcmDeviceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `authorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `instructorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `traineeID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `reportUserID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `registrationID` TEXT NOT NULL ,
  `manufacturer` VARCHAR(100) NULL DEFAULT NULL ,
  `model` VARCHAR(100) NULL DEFAULT NULL ,
  `product` VARCHAR(100) NULL DEFAULT NULL ,
  `messageCount` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `serialNumber` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`gcmDeviceID`) ,
  INDEX `administratorID` (`administratorID` ASC) ,
  INDEX `authorID` (`authorID` ASC) ,
  INDEX `instructorID` (`instructorID` ASC) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  INDEX `reportUserID` (`reportUserID` ASC) ,
  CONSTRAINT `gcmDevice_ibfk_1`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE CASCADE,
  CONSTRAINT `gcmDevice_ibfk_2`
    FOREIGN KEY (`authorID` )
    REFERENCES `coursemaker`.`author` (`authorID` )
    ON DELETE CASCADE,
  CONSTRAINT `gcmDevice_ibfk_3`
    FOREIGN KEY (`instructorID` )
    REFERENCES `coursemaker`.`instructor` (`instructorID` )
    ON DELETE CASCADE,
  CONSTRAINT `gcmDevice_ibfk_4`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `gcmDevice_ibfk_5`
    FOREIGN KEY (`reportUserID` )
    REFERENCES `coursemaker`.`reportUser` (`reportUserID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 72
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`guardian`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`guardian` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`guardian` (
  `guardianID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `lastName` VARCHAR(50) NULL DEFAULT NULL ,
  `email` VARCHAR(255) NOT NULL ,
  `cellphone` VARCHAR(50) NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  PRIMARY KEY (`guardianID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`guardianTrainee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`guardianTrainee` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`guardianTrainee` (
  `guardianTraineeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `guardianID` INT(10) UNSIGNED NOT NULL ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `activeFlag` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`guardianTraineeID`) ,
  INDEX `guardianID` (`guardianID` ASC) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  CONSTRAINT `guardianTrainee_ibfk_1`
    FOREIGN KEY (`guardianID` )
    REFERENCES `coursemaker`.`guardian` (`guardianID` )
    ON DELETE CASCADE,
  CONSTRAINT `guardianTrainee_ibfk_2`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`helpType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`helpType` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`helpType` (
  `helpTypeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `companyID` INT(10) UNSIGNED NOT NULL ,
  `helpTypeName` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`helpTypeID`) ,
  UNIQUE INDEX `index2` (`helpTypeName` ASC) ,
  INDEX `companyID` (`companyID` ASC) ,
  CONSTRAINT `helpType_ibfk_1`
    FOREIGN KEY (`companyID` )
    REFERENCES `coursemaker`.`company` (`companyID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`helpRequest`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`helpRequest` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`helpRequest` (
  `helpRequestID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseTraineeActivityID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `dateRequested` DATETIME NOT NULL ,
  `comment` TEXT NULL DEFAULT NULL ,
  `helpTypeID` INT(10) UNSIGNED NOT NULL ,
  `trainingClassID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`helpRequestID`) ,
  INDEX `fdd` (`helpTypeID` ASC) ,
  INDEX `fddx` (`courseTraineeActivityID` ASC) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  CONSTRAINT `helpRequest_ibfk_1`
    FOREIGN KEY (`helpTypeID` )
    REFERENCES `coursemaker`.`helpType` (`helpTypeID` )
    ON DELETE CASCADE,
  CONSTRAINT `helpRequest_ibfk_3`
    FOREIGN KEY (`courseTraineeActivityID` )
    REFERENCES `coursemaker`.`courseTraineeActivity` (`courseTraineeActivityID` )
    ON DELETE CASCADE,
  CONSTRAINT `helpRequest_ibfk_4`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`helpResponse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`helpResponse` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`helpResponse` (
  `helpResponseID` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `helpRequestID` INT(10) UNSIGNED NOT NULL ,
  `message` TEXT NULL DEFAULT NULL ,
  `dateResponse` DATETIME NULL DEFAULT NULL ,
  `scheduleMeeting` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `problemSorted` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `meetingDate` DATETIME NULL DEFAULT NULL ,
  `instructorID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`helpResponseID`) ,
  INDEX `helpRequestID` (`helpRequestID` ASC) ,
  INDEX `instructorID` (`instructorID` ASC) ,
  CONSTRAINT `helpResponse_ibfk_1`
    FOREIGN KEY (`helpRequestID` )
    REFERENCES `coursemaker`.`helpRequest` (`helpRequestID` )
    ON DELETE CASCADE,
  CONSTRAINT `helpResponse_ibfk_2`
    FOREIGN KEY (`instructorID` )
    REFERENCES `coursemaker`.`instructor` (`instructorID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`instructorClass`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`instructorClass` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`instructorClass` (
  `instructorClassID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `instructorID` INT(10) UNSIGNED NOT NULL ,
  `trainingClassID` INT(10) UNSIGNED NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  PRIMARY KEY (`instructorClassID`) ,
  UNIQUE INDEX `instructorID_2` (`instructorID` ASC, `trainingClassID` ASC) ,
  INDEX `instructorID` (`instructorID` ASC) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  CONSTRAINT `instructorClass_ibfk_1`
    FOREIGN KEY (`instructorID` )
    REFERENCES `coursemaker`.`instructor` (`instructorID` )
    ON DELETE CASCADE,
  CONSTRAINT `instructorClass_ibfk_2`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 40
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`instructorRating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`instructorRating` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`instructorRating` (
  `instructorRatingID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `instructorID` INT(10) UNSIGNED NOT NULL ,
  `courseTraineeActivityID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  `ratingID` INT(10) UNSIGNED NOT NULL ,
  `comment` TEXT NULL DEFAULT NULL ,
  `completedFlag` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`instructorRatingID`) ,
  INDEX `ix90` (`instructorID` ASC) ,
  INDEX `ix91` (`courseTraineeActivityID` ASC) ,
  INDEX `ix92` (`ratingID` ASC) ,
  INDEX `fk91` (`courseTraineeActivityID` ASC) ,
  INDEX `fk92` (`ratingID` ASC) ,
  INDEX `fk93` (`instructorID` ASC) ,
  CONSTRAINT `instructorRating_ibfk_1`
    FOREIGN KEY (`instructorID` )
    REFERENCES `coursemaker`.`instructor` (`instructorID` )
    ON DELETE CASCADE,
  CONSTRAINT `instructorRating_ibfk_2`
    FOREIGN KEY (`courseTraineeActivityID` )
    REFERENCES `coursemaker`.`courseTraineeActivity` (`courseTraineeActivityID` )
    ON DELETE CASCADE,
  CONSTRAINT `instructorRating_ibfk_3`
    FOREIGN KEY (`ratingID` )
    REFERENCES `coursemaker`.`rating` (`ratingID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 460
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`inventory` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`inventory` (
  `inventoryID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `equipmentID` INT(10) UNSIGNED NOT NULL ,
  `serialNumber` VARCHAR(45) NOT NULL ,
  `dateRegistered` DATETIME NULL DEFAULT NULL ,
  `conditionFlag` INT(11) NULL DEFAULT NULL ,
  `dateUpdated` DATETIME NULL DEFAULT NULL ,
  `model` VARCHAR(100) NULL DEFAULT NULL ,
  `yearPurchased` INT(11) NULL DEFAULT NULL ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`inventoryID`) ,
  UNIQUE INDEX `index4` (`serialNumber` ASC) ,
  INDEX `fkijh` (`equipmentID` ASC) ,
  INDEX `index5` (`administratorID` ASC) ,
  INDEX `fkadmnss` (`administratorID` ASC) ,
  INDEX `iinvx` (`equipmentID` ASC, `serialNumber` ASC) ,
  CONSTRAINT `inventory_ibfk_1`
    FOREIGN KEY (`equipmentID` )
    REFERENCES `coursemaker`.`equipment` (`equipmentID` )
    ON DELETE CASCADE,
  CONSTRAINT `inventory_ibfk_2`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 50
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`lessonResource`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`lessonResource` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`lessonResource` (
  `lessonResourceID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `activityID` INT(10) UNSIGNED NOT NULL ,
  `url` VARCHAR(255) NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  `resourceName` VARCHAR(255) NULL DEFAULT NULL ,
  `authorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `traineeID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `instructorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `localID` BIGINT(20) NULL DEFAULT NULL ,
  `syncDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`lessonResourceID`) ,
  INDEX `ixlr` (`activityID` ASC) ,
  INDEX `fkrsc` (`activityID` ASC) ,
  INDEX `index5` (`authorID` ASC) ,
  INDEX `index6` (`traineeID` ASC) ,
  INDEX `index7` (`instructorID` ASC) ,
  INDEX `fktrain` (`traineeID` ASC) ,
  INDEX `fkauth` (`authorID` ASC) ,
  INDEX `fkinst` (`instructorID` ASC) ,
  INDEX `actxcx` (`activityID` ASC) ,
  CONSTRAINT `lessonResource_ibfk_2`
    FOREIGN KEY (`authorID` )
    REFERENCES `coursemaker`.`author` (`authorID` ),
  CONSTRAINT `lessonResource_ibfk_3`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` ),
  CONSTRAINT `lessonResource_ibfk_4`
    FOREIGN KEY (`instructorID` )
    REFERENCES `coursemaker`.`instructor` (`instructorID` ),
  CONSTRAINT `actxcx`
    FOREIGN KEY (`activityID` )
    REFERENCES `coursemaker`.`activity` (`activityID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 109
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`lessonSchedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`lessonSchedule` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`lessonSchedule` (
  `lessonScheduleID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `trainingClassID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `activityID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  `scheduleDate` DATETIME NULL DEFAULT NULL ,
  `endDate` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`lessonScheduleID`) ,
  INDEX `ixll0` (`trainingClassID` ASC) ,
  INDEX `fkllx` (`activityID` ASC) ,
  INDEX `lessact` (`activityID` ASC) ,
  CONSTRAINT `lessonSchedule_ibfk_1`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE,
  CONSTRAINT `lessact`
    FOREIGN KEY (`activityID` )
    REFERENCES `coursemaker`.`activity` (`activityID` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`objective`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`objective` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`objective` (
  `objectiveID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseID` INT(10) UNSIGNED NOT NULL ,
  `objectiveName` VARCHAR(255) NOT NULL ,
  `description` TEXT NOT NULL ,
  PRIMARY KEY (`objectiveID`) ,
  INDEX `courseID` (`courseID` ASC) ,
  CONSTRAINT `objective_ibfk_1`
    FOREIGN KEY (`courseID` )
    REFERENCES `coursemaker`.`course` (`courseID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`teamMember`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`teamMember` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`teamMember` (
  `teamMemberID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `teamID` INT(10) UNSIGNED NOT NULL ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `activeFlag` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`teamMemberID`) ,
  UNIQUE INDEX `teamID_2` (`teamID` ASC, `traineeID` ASC) ,
  INDEX `teamID` (`teamID` ASC) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  CONSTRAINT `teamMember_ibfk_2`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `teamMember_ibfk_1`
    FOREIGN KEY (`teamID` )
    REFERENCES `coursemaker`.`team` (`teamID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`traineeEquipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`traineeEquipment` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`traineeEquipment` (
  `traineeEquipmentID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `inventoryID` INT(10) UNSIGNED NOT NULL ,
  `dateRegistered` DATETIME NULL DEFAULT NULL ,
  `dateReturned` DATETIME NULL DEFAULT NULL ,
  `conditionFlag` INT(11) NULL DEFAULT NULL ,
  `administratorID` INT(10) UNSIGNED NULL DEFAULT NULL ,
  PRIMARY KEY (`traineeEquipmentID`) ,
  INDEX `ixtr` (`traineeID` ASC) ,
  INDEX `ixeq` (`inventoryID` ASC) ,
  INDEX `fkadm` (`administratorID` ASC) ,
  CONSTRAINT `traineeEquipment_ibfk_1`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE,
  CONSTRAINT `traineeEquipment_ibfk_2`
    FOREIGN KEY (`inventoryID` )
    REFERENCES `coursemaker`.`inventory` (`inventoryID` )
    ON DELETE RESTRICT,
  CONSTRAINT `traineeEquipment_ibfk_3`
    FOREIGN KEY (`administratorID` )
    REFERENCES `coursemaker`.`administrator` (`administratorID` )
    ON DELETE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 100
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`traineeRating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`traineeRating` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`traineeRating` (
  `traineeRatingID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `courseTraineeActivityID` INT(10) UNSIGNED NOT NULL ,
  `ratingID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  `comment` TEXT NULL DEFAULT NULL ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`traineeRatingID`) ,
  INDEX `ixz00` (`courseTraineeActivityID` ASC) ,
  INDEX `ixz01` (`ratingID` ASC) ,
  INDEX `fkcc1` (`courseTraineeActivityID` ASC) ,
  INDEX `fkcc2` (`ratingID` ASC) ,
  INDEX `ixz03` (`traineeID` ASC) ,
  INDEX `fkcc3` (`traineeID` ASC) ,
  CONSTRAINT `traineeRating_ibfk_1`
    FOREIGN KEY (`courseTraineeActivityID` )
    REFERENCES `coursemaker`.`courseTraineeActivity` (`courseTraineeActivityID` )
    ON DELETE CASCADE,
  CONSTRAINT `traineeRating_ibfk_2`
    FOREIGN KEY (`ratingID` )
    REFERENCES `coursemaker`.`rating` (`ratingID` )
    ON DELETE CASCADE,
  CONSTRAINT `traineeRating_ibfk_3`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 279
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`traineeShout`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`traineeShout` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`traineeShout` (
  `traineeShoutID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `helpTypeID` INT(10) UNSIGNED NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `remarks` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`traineeShoutID`) ,
  INDEX `traineeID` (`traineeID` ASC) ,
  INDEX `helpTypeID` (`helpTypeID` ASC) ,
  CONSTRAINT `traineeShout_ibfk_2`
    FOREIGN KEY (`helpTypeID` )
    REFERENCES `coursemaker`.`helpType` (`helpTypeID` )
    ON DELETE CASCADE,
  CONSTRAINT `traineeShout_ibfk_1`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`traineeStatusType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`traineeStatusType` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`traineeStatusType` (
  `traineeStatusTypeID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `traineeStatusTypeName` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`traineeStatusTypeID`) ,
  UNIQUE INDEX `ix030` (`traineeStatusTypeName` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`traineeStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`traineeStatus` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`traineeStatus` (
  `traineeStatusID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `traineeID` INT(10) UNSIGNED NOT NULL ,
  `dateUpdated` DATETIME NOT NULL ,
  `traineeStatusTypeID` INT(10) UNSIGNED NOT NULL ,
  `remarks` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`traineeStatusID`) ,
  INDEX `ix040` (`traineeID` ASC) ,
  INDEX `ix041` (`traineeStatusTypeID` ASC) ,
  INDEX `fk040` (`traineeID` ASC) ,
  INDEX `fk041` (`traineeStatusTypeID` ASC) ,
  CONSTRAINT `traineeStatus_ibfk_1`
    FOREIGN KEY (`traineeID` )
    REFERENCES `coursemaker`.`trainee` (`traineeID` ),
  CONSTRAINT `traineeStatus_ibfk_2`
    FOREIGN KEY (`traineeStatusTypeID` )
    REFERENCES `coursemaker`.`traineeStatusType` (`traineeStatusTypeID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `coursemaker`.`trainingClassEvent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coursemaker`.`trainingClassEvent` ;

CREATE  TABLE IF NOT EXISTS `coursemaker`.`trainingClassEvent` (
  `trainingClassEventID` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `eventName` TEXT NULL DEFAULT NULL ,
  `description` TEXT NULL DEFAULT NULL ,
  `trainingClassID` INT(10) UNSIGNED NOT NULL ,
  `dateRegistered` DATETIME NOT NULL ,
  `location` TEXT NULL DEFAULT NULL ,
  `startDate` DATETIME NOT NULL ,
  `endDate` DATETIME NOT NULL ,
  `trainingClassCourseID` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`trainingClassEventID`) ,
  INDEX `trainingClassID` (`trainingClassID` ASC) ,
  INDEX `trainingClassCourseID` (`trainingClassCourseID` ASC) ,
  CONSTRAINT `trainingClassEvent_ibfk_2`
    FOREIGN KEY (`trainingClassCourseID` )
    REFERENCES `coursemaker`.`trainingClassCourse` (`trainingClassCourseID` )
    ON DELETE CASCADE,
  CONSTRAINT `trainingClassEvent_ibfk_1`
    FOREIGN KEY (`trainingClassID` )
    REFERENCES `coursemaker`.`trainingClass` (`trainingClassID` )
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
