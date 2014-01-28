package info.movito.themoviedbapi;

import info.movito.themoviedbapi.model.tv.TvSeries;
import info.movito.themoviedbapi.tools.ApiUrl;
import org.apache.commons.lang3.StringUtils;


public class TmdbTV extends AbstractApiElement {

    public static final String TMDB_METHOD_TV = "tv";


    public static enum EpisodeMethod {credits, external_ids, images}


    TmdbTV(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    /**
     * This method is used to retrieve all of the basic series information.
     *
     * @param seriesId
     * @param language
     */
    public TvSeries getSeries(int seriesId, String language, String... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_TV, seriesId);

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        apiUrl.appendToResponse(appendToResponse);

        return mapJsonResult(apiUrl, TvSeries.class);
    }
}
