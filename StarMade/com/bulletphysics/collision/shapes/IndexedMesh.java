package com.bulletphysics.collision.shapes;

import java.nio.ByteBuffer;

public class IndexedMesh
{
  public int numTriangles;
  public ByteBuffer triangleIndexBase;
  public int triangleIndexStride;
  public int numVertices;
  public ByteBuffer vertexBase;
  public int vertexStride;
  public ScalarType indexType;
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     com.bulletphysics.collision.shapes.IndexedMesh
 * JD-Core Version:    0.6.2
 */