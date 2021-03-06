package org.schema.schine.network.server;

import java.util.HashMap;
import org.schema.schine.network.NetworkProcessor;
import org.schema.schine.network.StateInterface;
import org.schema.schine.network.commands.LoginRequest;

public abstract interface ServerStateInterface extends StateInterface
{
  public abstract HashMap getClients();

  public abstract ServerControllerInterface getController();

  public abstract NetworkProcessor getProcessor(int paramInt);

  public abstract void setPaused(boolean paramBoolean);

  public abstract int getMaxClients();

  public abstract long getStartTime();

  public abstract String getServerName();

  public abstract String getServerDesc();

  public abstract String executeAdminCommand(String paramString1, String paramString2);

  public abstract int getSocketBufferSize();

  public abstract String getAcceptingIP();

  public abstract boolean filterJoinMessages();

  public abstract void addLoginRequest(LoginRequest paramLoginRequest);
}

/* Location:           C:\Users\Raul\Desktop\StarMade\StarMade.jar
 * Qualified Name:     org.schema.schine.network.server.ServerStateInterface
 * JD-Core Version:    0.6.2
 */