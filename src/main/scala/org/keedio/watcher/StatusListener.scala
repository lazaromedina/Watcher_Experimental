package org.keedio.watcher

/**
 * Created by luislazaro on 25/8/15.
 * lalazaro@keedio.com
 * Keedio
 */

/**
 * Interface for StatusEvent to inform other about
 * its status. When PathHdfsObject changes its status,
 * he will call the statuReceived method on each of his
 * listeners
 */
trait StatusListener {
    def statusReceived(event: StatusEvent):Unit

}
