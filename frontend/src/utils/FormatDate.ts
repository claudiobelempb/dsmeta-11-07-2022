import moment from 'moment';

export const FormatDateHour = (date: string) => {
  return moment(date).format('DD/MM/YYYY HH:mm');
};

export const FormatDate = (date: string) => {
  return moment(date).format('DD/MM/YYYY');
};

export const FormatIso8601 = (date: Date) => {
  return date.toISOString().slice(0, 10);
};
