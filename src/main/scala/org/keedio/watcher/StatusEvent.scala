package org.keedio.watcher

import java.util.EventObject
/**
 * Created by luislazaro on 25/8/15.
 * lalazaro@keedio.com
 * Keedio
 */

/**
 * Event class
 * StatusEvent holds on the source
 * @param source
 */
class StatusEvent(source: Object) extends EventObject(source){
}
