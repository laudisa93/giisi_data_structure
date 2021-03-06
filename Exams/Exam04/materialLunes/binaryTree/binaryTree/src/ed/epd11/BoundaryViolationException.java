package ed.epd11;

/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/**
 * InvalidNodeException.java
 * Copyright (C) 2008-2012 Miguel Garcia Torres
 */



/**
 *
 * @author Miguel Garcia Torres (mgarciat[at]upo[dot]es)
 */
public class BoundaryViolationException extends Exception {
    private static final long serialVersionUID = -6412833344293179782L;
    public BoundaryViolationException() {
    }

    public BoundaryViolationException(String msg){
        super(msg);
    }
}
