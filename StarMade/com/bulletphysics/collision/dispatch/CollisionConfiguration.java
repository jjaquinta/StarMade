package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;

public abstract class CollisionConfiguration
{
  public abstract CollisionAlgorithmCreateFunc getCollisionAlgorithmCreateFunc(BroadphaseNativeType paramBroadphaseNativeType1, BroadphaseNativeType paramBroadphaseNativeType2);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     com.bulletphysics.collision.dispatch.CollisionConfiguration
 * JD-Core Version:    0.6.2
 */