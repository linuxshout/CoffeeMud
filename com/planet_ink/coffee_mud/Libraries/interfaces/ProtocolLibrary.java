package com.planet_ink.coffee_mud.Libraries.interfaces;
import com.planet_ink.coffee_mud.core.interfaces.*;
import com.planet_ink.coffee_mud.core.*;
import com.planet_ink.coffee_mud.core.collections.*;
import com.planet_ink.coffee_mud.Abilities.interfaces.*;
import com.planet_ink.coffee_mud.Areas.interfaces.*;
import com.planet_ink.coffee_mud.Behaviors.interfaces.*;
import com.planet_ink.coffee_mud.CharClasses.interfaces.*;
import com.planet_ink.coffee_mud.Commands.interfaces.*;
import com.planet_ink.coffee_mud.Common.interfaces.*;
import com.planet_ink.coffee_mud.Exits.interfaces.*;
import com.planet_ink.coffee_mud.Items.interfaces.*;
import com.planet_ink.coffee_mud.Libraries.Sense;
import com.planet_ink.coffee_mud.Locales.interfaces.*;
import com.planet_ink.coffee_mud.MOBS.interfaces.*;
import com.planet_ink.coffee_mud.Races.interfaces.*;

import java.util.*;
/*
   Copyright 2013-2014 Bo Zimmerman

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
public interface ProtocolLibrary extends CMLibrary
{
	public String msp(final String soundName, final int priority);

	public String[] mxpImagePath(String fileName);
	public String mxpImage(final Environmental E, final String parms);
	public String mxpImage(final Environmental E, final String parms, final String pre, final String post);
	public String getDefaultMXPImage(final Object O);

	public byte[] processMsdp(final Session session, final char[] data, final int dataSize, final Map<Object,Object> reportables);
	public byte[] pingMsdp(final Session session, final Map<Object,Object> reportables);

	public byte[] processGmcp(final Session session, final String data, final Map<String,Double> supportables);
	public byte[] buildGmcpResponse(String json);
	public byte[] pingGmcp(final Session session, final Map<String,Long> reporteds, final Map<String,Double> supportables);
	
	public enum gmcpCommand
	{
		core_hello,
		core_supports_set,
		core_supports_add,
		core_supports_remove,
		core_keepalive,
		core_ping,
		core_goodbye,
		char_vitals,
		char_statusvars,
		char_status,
		char_base,
		char_maxstats,
		char_worth,
		char_items_inv, // means they want updates, dude
		char_items_contents,
		char_skills_get,
		group,
		room_info, // means they want room.wrongdir
		comm_channel,
		comm_channel_players,
		ire_composer_setbuffer
	}
}
