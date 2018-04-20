/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.repository.v2;

import ch.digitalfondue.npjt.*;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@QueryRepository
public interface V2Repository {


    @Query("insert into v2_event(short_name, start_time, end_time, time_zone) values (:shortName, :start, :end, :timeZone)")
    @AutoGeneratedKey("id")
    AffectedRowCountAndKey<BigInteger> insertEvent(@Bind("shortName") String shortName,
                                                   @Bind("start") ZonedDateTime begin,
                                                   @Bind("end") ZonedDateTime end,
                                                   @Bind("timeZone") String timeZone);


    @Query("insert into v2_resource(name, resource_id_fk) values (:name, :resourceId)")
    @AutoGeneratedKey("id")
    AffectedRowCountAndKey<BigInteger> insertResource(@Bind("name") String name,
                                                      @Bind("resourceId") BigInteger resourceId);

}
