/*
 * Copyright (c) 2018 Governikus KG. Licensed under the EUPL, Version 1.2 or as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work except
 * in compliance with the Licence. You may obtain a copy of the Licence at:
 * http://joinup.ec.europa.eu/software/page/eupl Unless required by applicable law or agreed to in writing,
 * software distributed under the Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package de.governikus.eumw.poseidas.server.eidservice;

import de.governikus.eumw.poseidas.ecardcore.utilities.ECardCoreUtil;
import oasis.names.tc.dss._1_0.core.schema.Result;



/**
 * A object of this class contains the response for a eID Request like a useID Request. This data is provided
 * by the {@link EIDInternal} class an then handled by the SAML validator or the eID-Webservice.
 * 
 * @author Hauke Mehrtens
 */
public class EIDRequestResponse
{

  private final String sessionId;

  private final String requestId;

  private final byte[] psk;

  private final String eCardServerAddress;

  private final String resultMajor;

  private final String resultMinor;

  private final String resultMessage;

  private final String logPrefix;


  EIDRequestResponse(String sessionId,
                            String requestId,
                            String resultMajor,
                            String resultMinor,
                            String resultMessage,
                            byte[] psk,
                            String eCardServerAddress,
                            String logPrefix)
  {
    this.sessionId = sessionId;
    this.requestId = requestId;
    this.resultMajor = resultMajor;
    this.resultMinor = resultMinor;
    this.resultMessage = resultMessage;
    this.psk = psk;
    this.eCardServerAddress = eCardServerAddress;
    this.logPrefix = logPrefix;
  }

  public String getSessionId()
  {
    return sessionId;
  }

  public String getRequestId()
  {
    return requestId;
  }

  public byte[] getPsk()
  {
    return psk;
  }

  public Result getResult()
  {
    Result result = new Result();
    result.setResultMajor(resultMajor);
    result.setResultMinor(resultMinor);
    result.setResultMessage(ECardCoreUtil.generateInternationalStringType(resultMessage));
    return result;
  }

  public String getResultMajor()
  {
    return resultMajor;
  }

  public String getResultMinor()
  {
    return resultMinor;
  }

  public String getResultMessage()
  {
    return resultMessage;
  }

  public String getECardServerAddress()
  {
    return eCardServerAddress;
  }

  public String getLogPrefix()
  {
    return logPrefix;
  }

}
