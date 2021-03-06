/*     */ package com.bulletphysics.dynamics.constraintsolver;
/*     */ 
/*     */ import com.bulletphysics..Stack;
/*     */ import com.bulletphysics.linearmath.VectorUtil;
/*     */ import javax.vecmath.Matrix3f;
/*     */ import javax.vecmath.Vector3f;
/*     */ 
/*     */ public class JacobianEntry
/*     */ {
/*  48 */   public final Vector3f linearJointAxis = new Vector3f();
/*  49 */   public final Vector3f aJ = new Vector3f();
/*  50 */   public final Vector3f bJ = new Vector3f();
/*  51 */   public final Vector3f m_0MinvJt = new Vector3f();
/*  52 */   public final Vector3f m_1MinvJt = new Vector3f();
/*     */   public float Adiag;
/*     */ 
/*     */   public void init(Matrix3f world2A, Matrix3f world2B, Vector3f rel_pos1, Vector3f rel_pos2, Vector3f jointAxis, Vector3f inertiaInvA, float massInvA, Vector3f inertiaInvB, float massInvB)
/*     */   {
/*  71 */     this.linearJointAxis.set(jointAxis);
/*     */ 
/*  73 */     this.aJ.cross(rel_pos1, this.linearJointAxis);
/*  74 */     world2A.transform(this.aJ);
/*     */ 
/*  76 */     this.bJ.set(this.linearJointAxis);
/*  77 */     this.bJ.negate();
/*  78 */     this.bJ.cross(rel_pos2, this.bJ);
/*  79 */     world2B.transform(this.bJ);
/*     */ 
/*  81 */     VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
/*  82 */     VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
/*  83 */     this.Adiag = (massInvA + this.m_0MinvJt.dot(this.aJ) + massInvB + this.m_1MinvJt.dot(this.bJ));
/*     */ 
/*  85 */     assert (this.Adiag > 0.0F);
/*     */   }
/*     */ 
/*     */   public void init(Vector3f jointAxis, Matrix3f world2A, Matrix3f world2B, Vector3f inertiaInvA, Vector3f inertiaInvB)
/*     */   {
/*  97 */     this.linearJointAxis.set(0.0F, 0.0F, 0.0F);
/*     */ 
/*  99 */     this.aJ.set(jointAxis);
/* 100 */     world2A.transform(this.aJ);
/*     */ 
/* 102 */     this.bJ.set(jointAxis);
/* 103 */     this.bJ.negate();
/* 104 */     world2B.transform(this.bJ);
/*     */ 
/* 106 */     VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
/* 107 */     VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
/* 108 */     this.Adiag = (this.m_0MinvJt.dot(this.aJ) + this.m_1MinvJt.dot(this.bJ));
/*     */ 
/* 110 */     assert (this.Adiag > 0.0F);
/*     */   }
/*     */ 
/*     */   public void init(Vector3f axisInA, Vector3f axisInB, Vector3f inertiaInvA, Vector3f inertiaInvB)
/*     */   {
/* 121 */     this.linearJointAxis.set(0.0F, 0.0F, 0.0F);
/* 122 */     this.aJ.set(axisInA);
/*     */ 
/* 124 */     this.bJ.set(axisInB);
/* 125 */     this.bJ.negate();
/*     */ 
/* 127 */     VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
/* 128 */     VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
/* 129 */     this.Adiag = (this.m_0MinvJt.dot(this.aJ) + this.m_1MinvJt.dot(this.bJ));
/*     */ 
/* 131 */     assert (this.Adiag > 0.0F);
/*     */   }
/*     */ 
/*     */   public void init(Matrix3f world2A, Vector3f rel_pos1, Vector3f rel_pos2, Vector3f jointAxis, Vector3f inertiaInvA, float massInvA)
/*     */   {
/* 144 */     this.linearJointAxis.set(jointAxis);
/*     */ 
/* 146 */     this.aJ.cross(rel_pos1, jointAxis);
/* 147 */     world2A.transform(this.aJ);
/*     */ 
/* 149 */     this.bJ.set(jointAxis);
/* 150 */     this.bJ.negate();
/* 151 */     this.bJ.cross(rel_pos2, this.bJ);
/* 152 */     world2A.transform(this.bJ);
/*     */ 
/* 154 */     VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
/* 155 */     this.m_1MinvJt.set(0.0F, 0.0F, 0.0F);
/* 156 */     this.Adiag = (massInvA + this.m_0MinvJt.dot(this.aJ));
/*     */ 
/* 158 */     assert (this.Adiag > 0.0F);
/*     */   }
/*     */   public float getDiagonal() {
/* 161 */     return this.Adiag;
/*     */   }
/*     */ 
/*     */   public float getNonDiagonal(JacobianEntry jacB, float massInvA)
/*     */   {
/* 167 */     JacobianEntry jacA = this;
/* 168 */     float lin = massInvA * jacA.linearJointAxis.dot(jacB.linearJointAxis);
/* 169 */     float ang = jacA.m_0MinvJt.dot(jacB.aJ);
/* 170 */     return lin + ang;
/*     */   }
/*     */ 
/*     */   public float getNonDiagonal(JacobianEntry arg1, float arg2, float arg3)
/*     */   {
/* 177 */     .Stack localStack = .Stack.get();
/*     */     try { localStack.push$javax$vecmath$Vector3f(); JacobianEntry jacA = this;
/*     */ 
/* 179 */       Vector3f lin = localStack.get$javax$vecmath$Vector3f();
/* 180 */       VectorUtil.mul(lin, jacA.linearJointAxis, jacB.linearJointAxis);
/*     */ 
/* 182 */       Vector3f ang0 = localStack.get$javax$vecmath$Vector3f();
/* 183 */       VectorUtil.mul(ang0, jacA.m_0MinvJt, jacB.aJ);
/*     */ 
/* 185 */       Vector3f ang1 = localStack.get$javax$vecmath$Vector3f();
/* 186 */       VectorUtil.mul(ang1, jacA.m_1MinvJt, jacB.bJ);
/*     */ 
/* 188 */       Vector3f lin0 = localStack.get$javax$vecmath$Vector3f();
/* 189 */       lin0.scale(massInvA, lin);
/*     */ 
/* 191 */       Vector3f lin1 = localStack.get$javax$vecmath$Vector3f();
/* 192 */       lin1.scale(massInvB, lin);
/*     */ 
/* 194 */       Vector3f sum = localStack.get$javax$vecmath$Vector3f();
/* 195 */       VectorUtil.add(sum, ang0, ang1, lin0, lin1);
/*     */ 
/* 197 */       return sum.x + sum.y + sum.z; } finally { localStack.pop$javax$vecmath$Vector3f(); } throw finally;
/*     */   }
/*     */ 
/*     */   public float getRelativeVelocity(Vector3f arg1, Vector3f arg2, Vector3f arg3, Vector3f arg4) {
/* 201 */     .Stack localStack = .Stack.get();
/*     */     try { localStack.push$javax$vecmath$Vector3f(); Vector3f linrel = localStack.get$javax$vecmath$Vector3f();
/* 202 */       linrel.sub(linvelA, linvelB);
/*     */ 
/* 204 */       Vector3f angvela = localStack.get$javax$vecmath$Vector3f();
/* 205 */       VectorUtil.mul(angvela, angvelA, this.aJ);
/*     */ 
/* 207 */       Vector3f angvelb = localStack.get$javax$vecmath$Vector3f();
/* 208 */       VectorUtil.mul(angvelb, angvelB, this.bJ);
/*     */ 
/* 210 */       VectorUtil.mul(linrel, linrel, this.linearJointAxis);
/*     */ 
/* 212 */       angvela.add(angvelb);
/* 213 */       angvela.add(linrel);
/*     */ 
/* 215 */       float rel_vel2 = angvela.x + angvela.y + angvela.z;
/* 216 */       return rel_vel2 + 1.192093E-007F; } finally { localStack.pop$javax$vecmath$Vector3f(); } throw finally;
/*     */   }
/*     */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     com.bulletphysics.dynamics.constraintsolver.JacobianEntry
 * JD-Core Version:    0.6.2
 */