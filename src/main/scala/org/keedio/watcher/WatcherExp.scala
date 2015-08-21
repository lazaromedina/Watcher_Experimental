package org.keedio.watcher

import java.nio.file.FileSystem
import java.nio.file.FileSystems
import java.nio.file.WatchService
import java.nio.file.WatchKey
import java.nio.file.WatchEvent
import java.nio.file.StandardWatchEventKinds._
import java.nio.file.Path
import java.nio.file.Paths

import java.io.File
import java.util

import org.apache.hadoop.fs
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.LocalFileSystem

import scala.collection.JavaConverters._

/**
 * Created by luislazaro on 21/8/15.
 * lalazaro@keedio.com
 * Keedio
 */
object WatcherExp {


    //    val localFileSystem: LocalFileSystem = org.apache.hadoop.fs.FileSystem.getLocal(new Configuration());
    //    val localFile: File = localFileSystem.pathToFile(new fs.Path("csvdir"))
    //    val path: java.nio.file.Path = localFile.toPath


    def main(args: Array[String]) {

        val watcher: WatchService = FileSystems.getDefault.newWatchService()
        val dir: java.nio.file.Path = Paths.get("/Users/luislazaro/folder")


        dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY)


        while (true) {
            val watchKey: WatchKey = watcher.take()
            val events: util.List[WatchEvent[_]] = watchKey.pollEvents()
            events.asScala.foreach( event =>
                event.kind() match {
                    case ENTRY_CREATE => {
                        println("creatdd entry")
                        System.exit(0)
                    }
                    case ENTRY_DELETE => {
                        println("deleted entry")
                        System.exit(0)
                    }
                    case ENTRY_MODIFY =>{
                        println("modified entry")
                        System.exit(0)
                    }

                    case _ => {
                        println("dont know what happened")
                        System.exit(1)
                    }

                }
            )
            watchKey.reset()
            }

        }

    }


