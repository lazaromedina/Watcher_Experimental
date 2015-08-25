package org.keedio.watcher

import scala.collection.mutable.ListBuffer

/**
 * Created by luislazaro on 25/8/15.
 * lalazaro@keedio.com
 * Keedio
 */

/**
 * The event generator (event source)
 */

class PathHdfsObject {

    val listeners: ListBuffer[StatusListener] = new ListBuffer[StatusListener]

    //timer and main logic
    //check for filesCount, access time, etc via hadoop FileStatus, so here is
    //needed a Hadoop Path.

    def addEventListener(listener: StatusListener): Unit = {
        listener +=: listeners
    }

    def removeEventListener(listener: StatusListener): Unit = {
        listeners.find(_ == listener) match {
            case Some(listener) => {
                listeners.remove(listeners.indexOf(listener))
            }
            case None => ()
        }

    }


    // call this method whenever you want to notify
    // the event listeners of the particular event
    private def fireEvent(): Unit = {
        val event: StatusEvent = new StatusEvent(this)
        listeners foreach (_.statusReceived(event))

    }
}
