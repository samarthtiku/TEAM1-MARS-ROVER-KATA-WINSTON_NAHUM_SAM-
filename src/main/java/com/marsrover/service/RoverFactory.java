package com.marsrover.service;

import com.marsrover.model.AbstractRover;
import com.marsrover.model.Orientation;
import com.marsrover.model.Plateau;


public interface RoverFactory {
    AbstractRover createRover(String id, int x, int y, Orientation orientation, Plateau plateau, String type);
}
