const emojiMap = {
  Freezing: "🥶",
  Bracing: "🌬️",
  Chilly: "🧊",
  Cool: "🌥️",
  Mild: "⛅",
  Warm: "☀️",
  Balmy: "🌞",
  Hot: "🔥",
  Sweltering: "🥵",
  Scorching: "🌋"
};

function cardClass(temperatureC) {
  if (temperatureC >= 30) return "card-hot";
  if (temperatureC >= 15) return "card-warm";
  if (temperatureC >= 0) return "card-cool";
  return "card-cold";
}

function badgeClass(temperatureC) {
  if (temperatureC >= 30) return "badge-hot";
  if (temperatureC >= 15) return "badge-warm";
  if (temperatureC >= 0) return "badge-cool";
  return "badge-cold";
}

function renderForecast(forecasts) {
  const cards = document.getElementById("cards");
  const tableBody = document.getElementById("table-body");

  cards.innerHTML = forecasts
    .map(
      (forecast) => `
        <div class="forecast-card ${cardClass(forecast.temperatureC)}">
          <div class="card-emoji">${emojiMap[forecast.summary] ?? "🌤️"}</div>
          <div class="card-date">${forecast.date}</div>
          <div class="card-temp">
            <span class="temp-value">${forecast.temperatureC}</span><span class="temp-unit">°C</span>
          </div>
          <div class="card-temp-secondary">${forecast.temperatureF}°F</div>
          <div class="card-summary">${forecast.summary}</div>
        </div>
      `
    )
    .join("");

  tableBody.innerHTML = forecasts
    .map(
      (forecast) => `
        <tr>
          <td>${emojiMap[forecast.summary] ?? "🌤️"}</td>
          <td>${forecast.date}</td>
          <td><span class="temp-badge ${badgeClass(forecast.temperatureC)}">${forecast.temperatureC}°</span></td>
          <td>${forecast.temperatureF}°</td>
          <td>${forecast.summary}</td>
        </tr>
      `
    )
    .join("");

  document.getElementById("loading").classList.add("d-none");
  cards.classList.remove("d-none");
  document.getElementById("table-section").classList.remove("d-none");
}

async function loadForecast() {
  try {
    const response = await fetch("/api/weatherforecast", { headers: { Accept: "application/json" } });
    if (!response.ok) {
      throw new Error(`Request failed with status ${response.status}`);
    }
    const forecasts = await response.json();
    renderForecast(forecasts);
  } catch (error) {
    document.getElementById("loading").classList.add("d-none");
    document.getElementById("error").classList.remove("d-none");
  }
}

loadForecast();
