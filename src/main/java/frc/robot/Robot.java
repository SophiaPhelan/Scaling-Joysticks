/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Drivetrain drivetrain = new Drivetrain();
  public static OI oi;

  public void robotInit() {
    oi = new OI();

  }

  public void robotPeriodic() {
  }

  public void disabledInit() {
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void testPeriodic() {
  }
}
