package com.netflix.atlas.core

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.MemoryLayoutSpecification

object DeepCalculator {

  private lazy val memoryLayoutSpecification = new MemoryLayoutSpecification {
    override def getArrayHeaderSize = 16
    override def getObjectHeaderSize = 12
    override def getObjectPadding = 8
    override def getReferenceSize = 4
    override def getSuperclassFieldPadding = 4
  }

  private lazy val objectSizeCalculator = new ObjectSizeCalculator(memoryLayoutSpecification)

  def sizeOf(o: Object) =
    objectSizeCalculator.calculateObjectSize(o)
}