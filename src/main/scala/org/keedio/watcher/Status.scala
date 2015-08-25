package org.keedio.watcher

/**
 * Created by luislazaro on 25/8/15.
 * lalazaro@keedio.com
 * Keedio
 */

/**
 * PathHdfsObject has three states. When he fires an event, the listener
 * will retrieve a status.
 * @param name
 */
class Status(name: String) {
  final val ENTRY_CREATE: Status = new Status("entry_create")
  final val ENTRY_DELETE: Status = new Status("entry_delete")
  final val ENTRY_MODIFY: Status = new Status("entry_modify")
  final val ENTRY_NORMAL: Status = new Status("entry_normal")

    override def toString(): String = {
        name
    }


}
