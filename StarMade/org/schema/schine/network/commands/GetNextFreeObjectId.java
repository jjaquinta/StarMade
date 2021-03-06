/*    */ package org.schema.schine.network.commands;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.schema.schine.network.Command;
/*    */ import org.schema.schine.network.IdGen;
/*    */ import org.schema.schine.network.client.ClientState;
/*    */ import org.schema.schine.network.client.ClientStateInterface;
/*    */ import org.schema.schine.network.server.ServerProcessor;
/*    */ import org.schema.schine.network.server.ServerStateInterface;
/*    */ 
/*    */ public class GetNextFreeObjectId extends Command
/*    */ {
/*    */   public GetNextFreeObjectId()
/*    */   {
/* 16 */     this.mode = 1;
/*    */   }
/*    */ 
/*    */   public void clientAnswerProcess(Object[] paramArrayOfObject, ClientStateInterface paramClientStateInterface, short paramShort)
/*    */   {
/* 21 */     System.err.println("Client got new ID range " + paramArrayOfObject[0]);
/* 22 */     paramClientStateInterface.setIdStartRange(((Integer)paramArrayOfObject[0]).intValue());
/*    */   }
/*    */ 
/*    */   public void serverProcess(ServerProcessor paramServerProcessor, Object[] paramArrayOfObject, ServerStateInterface paramServerStateInterface, short paramShort)
/*    */   {
/* 29 */     paramArrayOfObject = IdGen.getFreeObjectId(ClientState.NEW_ID_RANGE.intValue());
/* 30 */     System.err.println("SENDING new ID RANGE TO CLIENT " + paramArrayOfObject + "; packet " + paramShort);
/* 31 */     createReturnToClient(paramServerStateInterface, paramServerProcessor, paramShort, new Object[] { Integer.valueOf(paramArrayOfObject) });
/*    */   }
/*    */ }

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.schema.schine.network.commands.GetNextFreeObjectId
 * JD-Core Version:    0.6.2
 */